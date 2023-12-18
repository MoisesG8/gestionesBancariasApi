package com.banco.gestiones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class TipoSolicitudes {

    @Id
    private  int TipoSolicitudID;
    private String NombreTipo;
    private String Descripcion;
}
