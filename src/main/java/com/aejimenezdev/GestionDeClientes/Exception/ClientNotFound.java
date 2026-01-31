package com.aejimenezdev.GestionDeClientes.Exception;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound() {
        super("The client was not found.");
    }
}
