package com.colegio.aplicacionapi.models;

import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "empresas")
public class Empresa {
    @Id
    private String id;
    @Indexed(unique = true)
    private String nombre;
    private String direccion;
    private String telefono;
    //Listas o Incrustaciones
    private List<JefeDirecto> jefesDirecto = new ArrayList<>();
    private List<Practica> practicas = new ArrayList<>();
}
