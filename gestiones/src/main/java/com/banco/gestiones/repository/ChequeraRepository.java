package com.banco.gestiones.repository;

import com.banco.gestiones.model.Chequera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChequeraRepository implements InterfaceChequera {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearNuevaChequera(Chequera chequera){
        int resultado = 0;
        String SQL = "INSERT INTO Chequeras (CuentaID, CantidadCheques, EstadoChequera, FechaVencimiento)\n" +
                "VALUES(?, ?, ?, ?)";

        resultado = jdbcTemplate.update(SQL, chequera.getCuenta().getId(), chequera.getCantidadCheques(), chequera.getEstadoChequera(), chequera.getFechaVencimiento());

        return resultado;
    }
}
