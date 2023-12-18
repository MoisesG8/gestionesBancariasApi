package com.banco.gestiones.repository;

import com.banco.gestiones.model.Cuenta;
import com.banco.gestiones.model.TipoCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CuentaRepository implements InterfaceCuenta{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addCuentaAhorro(Cuenta cuenta) {
        System.out.println("Logger en repository de cuenta " + cuenta);
        String SQL = "INSERT INTO Cuentas(ClienteID, TipoCuentaID, Monto, Estado) " +
                "VALUES (?, ?, ?, ?)";
        int resultado = jdbcTemplate.update(SQL, cuenta.getCliente().getClienteID(), cuenta.getTipoCuentas().getTipoCuentaID(), cuenta.getMonto(), cuenta.getEstado());
        return resultado;
    }


    @Override
    public TipoCuentas obtenerTipoCuenta(int ID) {
        System.out.println("parametro id CUENTA REPOSITORY " + ID);

        String SQL = "SELECT * FROM TiposDeCuentas WHERE TipoCuentaID = ?";

        // Utilizar un RowMapper para asignar el resultado a la entidad TipoCuentas
        return jdbcTemplate.queryForObject(SQL, new Object[]{ID}, new BeanPropertyRowMapper<>(TipoCuentas.class));
    }

    @Override
    public int obtenerIDCuenta(Cuenta cuenta) {
        // Sentencia de inserción
        String insertSQL = "INSERT INTO Cuentas(ClienteID, TipoCuentaID, Monto, Estado) VALUES (?, ?, ?, ?)";

        // Ejecutar la operación de inserción
        jdbcTemplate.update(insertSQL, cuenta.getCliente().getClienteID(), cuenta.getTipoCuentas().getTipoCuentaID(),
                cuenta.getMonto(), cuenta.getEstado());

        // Sentencia para recuperar el ID del registro recién creado
        String selectSQL = "SELECT IDENT_CURRENT('Cuentas')"; // Ajusta esto según tu base de datos y tabla

        // Recuperar el ID del registro recién creado
        return jdbcTemplate.queryForObject(selectSQL, int.class);
    }

}
