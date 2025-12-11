package com.colegio.aplicacionapi.models;

import jakarta.persistence.Id;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "profesores")
public class Profesor {
    @Id
    private String id;
    @Indexed(unique = true)
    private String nombreCompleto;
    private String email;
    private String departamento;
     //Listas o Incrustaciones
    private List<Practica> PracticasSupervisadas;
}
