package com.colegio.aplicacionapi.responses;

import lombok.Data;

@Data
public class EmpresaResponse {

    private String id;
    private String nombre;
    private String direccion;   
    private String telefono;
    private String mensaje;
    public EmpresaResponse(String id, String nombre, String direccion, String telefono, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }
}
