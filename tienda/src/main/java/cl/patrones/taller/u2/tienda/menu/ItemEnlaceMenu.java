package cl.patrones.taller.u2.tienda.menu;

import java.util.ArrayList;
import java.util.List;

public class ItemEnlaceMenu implements ItemMenu {

    private final String texto;
    private final String enlace;
    private final List<ItemMenu> hijos = new ArrayList<>();

    public ItemEnlaceMenu(String texto, String enlace) {
        this.texto = texto;
        this.enlace = enlace;
    }

    public void agregarHijo(ItemMenu hijo) {
        hijos.add(hijo);
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getSlug() {
        return null; // Para enlaces fijos no es necesario el slug
    }

    @Override
    public String getEnlace() {
        return enlace;
    }

    @Override
    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }

    @Override
    public List<ItemMenu> getHijos() {
        return hijos;
    }
}
