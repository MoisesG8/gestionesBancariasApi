package com.banco.gestiones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
public class Chequera {

    @Id
    private int ChequeraID;

    @ManyToOne
    @JoinColumn(name = "CuentaID")
    private Cuenta cuenta;

    private int CantidadCheques;

    private String EstadoChequera;

    private Date FechaVencimiento;

    public void setCuentaID(int cuentaID) {
        // Aquí podrías cargar la cuenta desde la base de datos
        // utilizando el ID y establecerla en el objeto Chequera
        this.cuenta = new Cuenta();
        this.cuenta.setId(cuentaID);
    }


}
