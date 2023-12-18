package com.banco.gestiones.repository;

import com.banco.gestiones.model.Cliente;
import com.banco.gestiones.model.Cuenta;

import java.util.List;
import java.util.Map;

public interface InterfaceCliente {

    public List<Cliente> findAll();

    public List<Map<String, Object>> obtenerClientesycuentas(int ID);

    public Cliente consultarCliente(int ID);
    public int crearCliente(Cliente cliente);

    public int bajaCliente(int ID);

    public int actualizarCliente(Cliente cliente);
}
