package com.colegio.aplicacionapi.responses;

import lombok.Data;

@Data
public class EstudianteResponse {

    private String id;
    private String nombreCompleto;
    private String carrera;
    private String email;
    private String telefono;

    public EstudianteResponse(
            String id,
            String nombreCompleto,
            String carrera,
            String email,
            String telefono
    ) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.email = email;
        this.telefono = telefono;
    }
}
