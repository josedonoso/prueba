package cl.patrones.taller.u2.tienda.menu;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoriaMenu implements ItemMenu {

    private final Categoria categoria;
    private final List<ItemCategoriaMenu> hijos = new ArrayList<>();

    public ItemCategoriaMenu(Categoria categoria) {
        this.categoria = categoria;
    }

    public void agregarHijo(ItemCategoriaMenu hijo) {
        hijos.add(hijo);
    }

    @Override
    public String getTexto() {
        return categoria.getNombre();
    }

    @Override
    public String getSlug() {
        return Slugger.toSlug(categoria.getNombre());
    }

    @Override
    public String getEnlace() {
        return "/categoria/" + categoria.getId() + "/" + getSlug();
    }

    @Override
    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }

    @Override
    public List<ItemCategoriaMenu> getHijos() {
        return hijos;
    }
}
