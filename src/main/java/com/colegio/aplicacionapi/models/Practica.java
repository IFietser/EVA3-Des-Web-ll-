package com.colegio.aplicacionapi.models;
import jakarta.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "practicas")
public class Practica {
    @Id
    private String id;

    private String descripcionActividades;
    private String fechaInicio;
    private String fechaTermino;

    private Estudiante estudiante;
    private Profesor profesorSupervisor;
    private Empresa empresa;
    private JefeDirecto jefeDirecto;
}
