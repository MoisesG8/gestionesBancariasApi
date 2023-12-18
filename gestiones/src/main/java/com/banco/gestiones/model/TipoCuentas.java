package com.banco.gestiones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class TipoCuentas {

    @Id
    private  int TipoCuentaID;
    private String NombreTipo;
    private String Descripcion;

    @Override
    public String toString() {
        return "TipoCuentas{" +
                "TipoCuentaID=" + TipoCuentaID +
                ", NombreTipo='" + NombreTipo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
