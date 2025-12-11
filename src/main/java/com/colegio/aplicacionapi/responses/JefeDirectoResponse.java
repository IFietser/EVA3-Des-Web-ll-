package com.colegio.aplicacionapi.responses;


import lombok.Data;

@Data
public class JefeDirectoResponse {

    private String id;
    private String nombreCompleto;
    private String telefono;
    private String email;

    public JefeDirectoResponse(
        String id,
        String nombreCompleto,
        String telefono,
        String email
    ) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }
}
