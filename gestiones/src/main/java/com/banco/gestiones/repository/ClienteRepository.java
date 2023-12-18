package com.banco.gestiones.repository;

import com.banco.gestiones.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ClienteRepository implements InterfaceCliente {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cliente> findAll(){
        List<Cliente> clientes = new ArrayList<>();
        String SQL = "select * from Clientes WHERE Estado = 'A'";
        try{
            clientes = jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cliente.class));
        }catch (Exception e){
            System.out.println("Error: "+ e);
            clientes.clear();
        }

        return clientes;
    }

    @Override
    public Cliente consultarCliente(int ID) {
        System.out.println("parametro id " + ID);
        String SQL = "SELECT * FROM Clientes WHERE ClienteID = ?";

        // Utilizar un RowMapper para asignar el resultado a la entidad Cliente
        return jdbcTemplate.queryForObject(SQL, new Object[]{ID}, new BeanPropertyRowMapper<>(Cliente.class));
    }

    @Override
    public int actualizarCliente(Cliente cliente) {
        String SQL = "UPDATE Clientes SET Nombre =?, Apellido =?, Direccion =?, CorreoElectronico =?, Telefono =? WHERE ClienteID =?";
        return jdbcTemplate.update(SQL, new Object[]{cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getCorreoElectronico(), cliente.getTelefono(),
        cliente.getClienteID()});
    }

    @Override
    public int crearCliente(Cliente cliente){
        String SQL = "INSERT INTO Clientes (Nombre, Apellido, NumeroIdentificacion, FechaNacimiento, Direccion, CorreoElectronico, Telefono, Estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, 'A')";

        return jdbcTemplate.update(SQL, cliente.getNombre(), cliente.getApellido(), cliente.getNumeroIdentificacion(),
                cliente.getFechaNacimiento(), cliente.getDireccion(), cliente.getCorreoElectronico(),
                cliente.getTelefono());

    }

    @Override
    public int bajaCliente(int ID) {
        String SQL = "UPDATE Clientes\n" +
                "SET Estado = 'B'\n" +
                "WHERE ClienteID = ?";
        return jdbcTemplate.update(SQL, ID);
    }

    @Override
    public List<Map<String, Object>> obtenerClientesycuentas(int ID) {
        String SQL = "SELECT cl.Nombre, cu.Estado, cu.Monto, cu.NumeroCuenta, tc.NombreTipo FROM Clientes as cl\n" +
                "INNER JOIN Cuentas as cu\n" +
                "ON cl.ClienteID = cu.ClienteID\n" +
                "INNER JOIN TiposDeCuentas AS tc\n" +
                "ON tc.TipoCuentaID = cu.TipoCuentaID WHERE cl.ClienteID = "+ID;
        return jdbcTemplate.query(SQL, new MapRowMapper());
    }

    private static class MapRowMapper implements RowMapper<Map<String, Object>> {
        @Override
        public Map<String, Object> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Map<String, Object> resultMap = new HashMap<>();
            // Puedes ajustar los nombres de las columnas según tu consulta SQL
            resultMap.put("Nombre", resultSet.getObject("Nombre"));
            resultMap.put("Estado", resultSet.getObject("Estado"));
            resultMap.put("Monto", resultSet.getObject("Monto"));
            resultMap.put("NumeroCuenta", resultSet.getObject("NumeroCuenta"));
            resultMap.put("NombreTipo", resultSet.getObject("NombreTipo"));
            return resultMap;
        }
    }
}
