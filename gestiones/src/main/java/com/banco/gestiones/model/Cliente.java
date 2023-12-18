package com.banco.gestiones.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
public class Cliente {

    @Id
    private int ClienteID;
    @NonNull
    private String Nombre;
    @NonNull
    private String Apellido;
    @NonNull
    private String NumeroIdentificacion;
    @NonNull
    private Date FechaNacimiento;
    @NonNull
    private String Direccion;
    @NonNull
    private String CorreoElectronico;
    @NonNull
    private String Telefono;
    @NonNull
    private String Estado;

    public Cliente() {

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ClienteID=" + ClienteID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", NumeroIdentificacion='" + NumeroIdentificacion + '\'' +
                ", FechaNacimiento=" + FechaNacimiento +
                ", Direccion='" + Direccion + '\'' +
                ", CorreoElectronico='" + CorreoElectronico + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
