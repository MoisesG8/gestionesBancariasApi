package com.banco.gestiones.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class Cuenta {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "ClienteID")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "TipoCuentaID")
    private TipoCuentas tipoCuentas;

    private Double Monto;
    private String Estado;

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", tipoCuentas=" + tipoCuentas +
                ", Monto=" + Monto +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
