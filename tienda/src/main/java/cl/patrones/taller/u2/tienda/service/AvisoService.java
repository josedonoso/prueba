package cl.patrones.taller.u2.tienda.service;

import cl.patrones.taller.u2.catalogo.domain.Aviso;

import java.util.List;

public interface AvisoService {
    List<Aviso> listarAvisos();
    List<Aviso> listarAvisosPorCategoria(Long categoriaId);


    
}
