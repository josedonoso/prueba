package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.clientes.Cliente;  // Aquí el paquete correcto



public class UsuarioAnonimo extends Usuario {

    public UsuarioAnonimo() {
        super(new Cliente());
        getCliente().setNombre("Invitado");

    }

    @Override
    public Cliente getCliente() {
        return super.getCliente();
    }
}
