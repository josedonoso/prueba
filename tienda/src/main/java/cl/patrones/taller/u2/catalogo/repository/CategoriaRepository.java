package cl.patrones.taller.u2.catalogo.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import cl.patrones.taller.u2.catalogo.domain.Categoria;

public interface CategoriaRepository extends ListCrudRepository<Categoria, Long> {
    List<Categoria> findByPadreIsNull();
}
