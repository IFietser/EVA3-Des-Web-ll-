package com.colegio.aplicacionapi.responses;

import lombok.Data;

@Data
public class GenericResponse {
    private String mensaje;

    public GenericResponse(String mensaje) {
        this.mensaje = mensaje;
    }
}
