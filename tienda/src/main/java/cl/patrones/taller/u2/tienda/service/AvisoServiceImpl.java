package cl.patrones.taller.u2.tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.domain.Stock;
import cl.patrones.taller.u2.bodegaje.service.ProductoService;


@Service
public class AvisoServiceImpl implements AvisoService {

    @Autowired
    private ProductoService productoService;

    @Override
    public List<Aviso> listarAvisos() {
        List<Producto> productos = productoService.listarProductos();
        return productos.stream()
                .map(this::convertirProductoAAviso)
                .collect(Collectors.toList());
    }

    @Override
    public List<Aviso> listarAvisosPorCategoria(Long categoriaId) {
        System.out.println("Buscando productos de la categoría con id: " + categoriaId);
        List<Producto> productos = productoService.listarProductosPorCategoria(categoriaId);
        System.out.println("Cantidad de productos encontrados: " + productos.size());
        return productos.stream()
            .map(this::convertirProductoAAviso)
            .collect(Collectors.toList());
    }

    // Método que convierte Producto a Aviso (asumiendo que tienes uno)
    private Aviso convertirProductoAAviso(Producto producto) {
        long precioConUtilidad = Math.round(producto.getCosto() * 1.3); // 30% utilidad
        int stockTotal = producto.getStocks().stream().mapToInt(Stock::getCantidad).sum();

        return new Aviso(
            producto.getId(),
            producto.getNombre(),
            producto.getSku(),
            precioConUtilidad,
            producto.getImagen(),
            stockTotal,
            producto.getCategoria()
        );
    }
}
