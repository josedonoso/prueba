package cl.patrones.taller.u2.bodegaje.service;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();
    List<Producto> listarProductosPorCategoria(Long categoriaId);

    Producto obtenerPorId(Long id);
    
}
