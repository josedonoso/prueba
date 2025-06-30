package cl.patrones.taller.u2.bodegaje.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
    //private List<Producto> productos = new ArrayList<>();

     @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl() {
        // Constructor vacío
    }


    /*@Override
    public List<Producto> listarProductosPorCategoria(Long categoriaId) {
        return productos.stream()
                .filter(p -> p.getCategoria() != null && p.getCategoria().getId().equals(categoriaId))
                .collect(Collectors.toList());
    }*/

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }
}
