package com.colegio.aplicacionapi.responses;

import lombok.Data;

@Data
public class PracticaResponse {
    private String id;
    private String descripcionActividades;
    private String fechaInicio;
    private String fechaTermino;

    private String estudiante;
    private String profesor;
    private String empresa;
    private String jefeDirecto;

    public PracticaResponse(
        String id,
        String descripcionActividades,
        String fechaInicio,
        String fechaTermino,
        String estudiante,
        String profesor,
        String empresa,
        String jefeDirecto
    ) {
        this.id = id;
        this.descripcionActividades = descripcionActividades;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estudiante = estudiante;
        this.profesor = profesor;
        this.empresa = empresa;
        this.jefeDirecto = jefeDirecto;
    }
}
