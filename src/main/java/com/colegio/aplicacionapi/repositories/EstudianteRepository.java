package com.colegio.aplicacionapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.colegio.aplicacionapi.models.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

}