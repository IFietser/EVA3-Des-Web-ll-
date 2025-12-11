package com.colegio.aplicacionapi.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "estudiantes")
public class Estudiante {
    @Id
    private String id;
    @Indexed(unique = true)
    private String nombreCompleto;
    private String carrera;
    private String email;
    private String telefono;
    //Listas o Incrustaciones
    private List<Practica> Practica;
}
