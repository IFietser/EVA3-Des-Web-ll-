package com.colegio.aplicacionapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.colegio.aplicacionapi.models.Profesor;

public interface ProfesorRepository extends MongoRepository <Profesor, String> {

    Profesor findByNombreCompleto(String nombreCompleto);
}
