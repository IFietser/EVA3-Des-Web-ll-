package com.colegio.aplicacionapi.models;
import jakarta.persistence.Id;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "jefes_directos")
public class JefeDirecto {
    @Id
    private String id;
    @Indexed(unique = true)
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String empresaId;
    //Listas o Incrustaciones
    private List<Practica> Practica;
}

