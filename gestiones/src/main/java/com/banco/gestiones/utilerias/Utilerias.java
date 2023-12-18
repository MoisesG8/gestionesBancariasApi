package com.banco.gestiones.utilerias;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilerias {
    public static Date generarFechaVencimiento() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Agregar 6 meses a la fecha actual
        LocalDate fechaVencimiento = fechaActual.plusMonths(6);

        // Formatear la fecha en el formato deseado "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaVencimientoFormateada = fechaVencimiento.format(formatter);

        // Convertir la fecha formateada a java.sql.Date
        Date fechaSqlDate = Date.valueOf(fechaVencimientoFormateada);

        System.out.println("Fecha convertida a java.sql.Date: " + fechaSqlDate);

        return fechaSqlDate;
    }
}
