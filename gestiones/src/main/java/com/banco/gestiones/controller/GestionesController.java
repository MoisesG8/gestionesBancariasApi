package com.banco.gestiones.controller;

import com.banco.gestiones.model.Cliente;
import com.banco.gestiones.model.RespuestaService;
import com.banco.gestiones.service.GestionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gestiones")
@CrossOrigin("*")
public class GestionesController {
    @Autowired
    GestionesService gestionesService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosClientes() {
        return new ResponseEntity<List<Cliente>>(gestionesService.obtenerClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RespuestaService> actualizarCliente(@RequestBody Cliente c){
        RespuestaService respuesta = new RespuestaService();
        int resultado = gestionesService.actualizarCliente(c);
        if (resultado == 1) {
            respuesta.setMensaje("El cliente ha sido actualizado con éxito");
            respuesta.setExito(true);
        } else {
            respuesta.setMensaje("Ocurrio un problema al actualizar al cliente..");
            respuesta.setExito(false);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @PostMapping("/agregarCliente")
    public ResponseEntity<RespuestaService> crearCliente(@RequestBody Cliente c) {
        RespuestaService respuesta = new RespuestaService();
        int resultado = gestionesService.agregarCliente(c);
        if (resultado == 1) {
            respuesta.setMensaje("El cliente ha sido agregado con éxito");
            respuesta.setExito(true);
        } else {
            respuesta.setMensaje("Ocurrio un problema al registrar al cliente..");
            respuesta.setExito(false);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PostMapping("/agregarCuenta")
    public ResponseEntity<RespuestaService> crearCuenta(@RequestBody Map parametros) {
        RespuestaService respuesta = new RespuestaService();
        int resultado = gestionesService.agregarCuenta(parametros);
        if (resultado == 1) {
            respuesta.setMensaje("La cuenta ha sido creada con éxito");
            respuesta.setExito(true);
        } else {
            respuesta.setMensaje("Ocurrio un problema al registrar la cuenta");
            respuesta.setExito(false);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerClientesYCuentas")
    public ResponseEntity<List<Map<String, Object>>> obtenerClientesycuentas(@RequestParam int ID) {
        List<Map<String, Object>> listaRespuesta = gestionesService.obtenerClientesYCuentas(ID);

        return new ResponseEntity<>(listaRespuesta, HttpStatus.OK);

    }

    @PostMapping("/bajaCliente")
    public ResponseEntity<RespuestaService> bajaCliente(@RequestBody Map parametros) {
        RespuestaService respuesta = new RespuestaService();
        int resultado = gestionesService.bajaCliente((Integer) parametros.get("idCliente"));
        if (resultado == 1) {
            respuesta.setMensaje("Se dio de baja al cliente");
            respuesta.setExito(true);
        } else {
            respuesta.setMensaje("Ocurrio un error al dar de cliente");
            respuesta.setExito(false);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }


}
