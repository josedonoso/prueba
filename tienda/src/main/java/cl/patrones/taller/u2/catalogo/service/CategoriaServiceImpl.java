package cl.patrones.taller.u2.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
	
	@Override
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> getCategoriaPorId(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
    public List<Categoria> getCategoriasRaiz() {
        return categoriaRepository.findByPadreIsNull();
    }

	
}
