package com.banco.gestiones.service;

import com.banco.gestiones.model.Chequera;
import com.banco.gestiones.model.Cliente;
import com.banco.gestiones.model.Cuenta;
import com.banco.gestiones.model.TipoCuentas;
import com.banco.gestiones.repository.InterfaceChequera;
import com.banco.gestiones.repository.InterfaceCliente;
import com.banco.gestiones.repository.InterfaceCuenta;
import com.banco.gestiones.utilerias.Utilerias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class GestionesService {

    @Autowired
    InterfaceCliente interfaceCliente;

    @Autowired
    InterfaceCuenta interfaceCuenta;

    @Autowired
    InterfaceChequera interfaceChequera;


    public List<Cliente> obtenerClientes() {

        return interfaceCliente.findAll();

    }

    public int agregarCliente(Cliente c) {

        return interfaceCliente.crearCliente(c);

    }

    public int bajaCliente(int ID){

        return interfaceCliente.bajaCliente(ID);
    }

    public int actualizarCliente(Cliente c){

        return interfaceCliente.actualizarCliente(c);
    }

    public List<Map<String, Object>> obtenerClientesYCuentas(int ID) {
        List<Map<String, Object>> clientesyCuentas;
        clientesyCuentas = interfaceCliente.obtenerClientesycuentas(ID);
        return clientesyCuentas;
    }

    public int agregarCuenta(Map parametros) {
        Cuenta cuenta = new Cuenta();
        int resultado = 0;
        System.out.println(parametros);
        try {
            int idCliente = Integer.parseInt(parametros.get("idCliente").toString());
            int idTipoCuenta = Integer.parseInt(parametros.get("idTipoCuenta").toString());
            Cliente cliente = interfaceCliente.consultarCliente(idCliente);
            TipoCuentas tipoCuentas = interfaceCuenta.obtenerTipoCuenta(idTipoCuenta);
            cuenta.setCliente(cliente);
            cuenta.setTipoCuentas(tipoCuentas);
            cuenta.setEstado(parametros.get("estado").toString());
            cuenta.setMonto(Double.valueOf(parametros.get("monto").toString()));
            if (idTipoCuenta == 1){
                System.out.println("Se creo la nueva cuenta de Ahorro");
                resultado = interfaceCuenta.addCuentaAhorro(cuenta);

            } else {
                Chequera chequera = new Chequera();
                int idCuentaNueva = interfaceCuenta.obtenerIDCuenta(cuenta);
                System.out.println("Cuenta monetaria "+ idCuentaNueva);
                chequera.setCuentaID(idCuentaNueva);
                chequera.setCantidadCheques((Integer) parametros.get("cantidadCheques"));
                chequera.setEstadoChequera((String) parametros.get("estadoChequera"));
                chequera.setFechaVencimiento(Utilerias.generarFechaVencimiento());

                resultado = interfaceChequera.crearNuevaChequera(chequera);
                System.out.println("Se creo la nueva cuenta Monetaria y su respectiva chequera");
            }
        } catch (Exception e) {
            System.out.println("Error al momento de agregar una Cuenta " + e);
            resultado = 0;
            return resultado;
        }

        return resultado;
    }

}
