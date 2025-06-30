package cl.patrones.taller.u2.tienda.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.menu.ItemCategoriaMenu;
import cl.patrones.taller.u2.tienda.menu.ItemEnlaceMenu;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MenuControllerAdvice {

	private final CategoriaService categoriaService;

	public MenuControllerAdvice(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

	@ModelAttribute("menu")
    public List<ItemMenu> menu() {
        List<ItemMenu> menu = new ArrayList<>();

        menu.add(new ItemEnlaceMenu("Inicio", "/"));

        ItemEnlaceMenu categoriasItem = new ItemEnlaceMenu("Categorías", "/categoria");
        
        for (Categoria categoria : categoriaService.getCategoriasRaiz()) {
            categoriasItem.agregarHijo(construirCategoriaMenu(categoria));
        }
        
        menu.add(categoriasItem);

        menu.add(new ItemEnlaceMenu("Ubicación", "/ubicacion"));
        menu.add(new ItemEnlaceMenu("Contacto", "/contacto"));
        

        return menu;
    }

	private ItemCategoriaMenu construirCategoriaMenu(Categoria categoria) {
        ItemCategoriaMenu item = new ItemCategoriaMenu(categoria);
        for (Categoria sub : categoria.getHijos()) {
            item.agregarHijo(construirCategoriaMenu(sub));
        }
        return item;
    }
	
}
