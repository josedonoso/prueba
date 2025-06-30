package cl.patrones.taller.u2.tienda.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.service.AvisoService;

@Controller
public class TiendaController {
	
	@Autowired
    private AvisoService avisoService;

    @Autowired
    private CategoriaService categoriaService;

	@GetMapping("/")
	public String inicio(Model model) {
		List<Aviso> avisos = avisoService.listarAvisos();
		model.addAttribute("avisos", avisos);
		return "inicio";
	}


	@GetMapping("/categoria/{categoriaId}/{slug}")
	public String categoria(@PathVariable Long categoriaId, @PathVariable String slug, Model model) {
		List<Aviso> avisos = avisoService.listarAvisosPorCategoria(categoriaId);
		Optional<Categoria> categoria = categoriaService.getCategoriaPorId(categoriaId);

		model.addAttribute("avisos", avisos);
		model.addAttribute("categoria", categoria.orElse(null)); // pasa null si no existe

		return "categoria";  // apunta a la vista categoria.html
}

	
	@GetMapping("/ingresar")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion() {return "ubicacion";}
	
	@GetMapping("/contacto")
	public String contacto() {return "contacto";}
	
}
