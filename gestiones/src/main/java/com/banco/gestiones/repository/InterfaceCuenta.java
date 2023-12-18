package com.banco.gestiones.repository;

import com.banco.gestiones.model.Cuenta;
import com.banco.gestiones.model.TipoCuentas;

public interface InterfaceCuenta {

    public int addCuentaAhorro(Cuenta cuenta);

    public int obtenerIDCuenta(Cuenta cuenta);


    public TipoCuentas obtenerTipoCuenta(int ID);

}
