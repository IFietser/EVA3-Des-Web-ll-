package com.colegio.aplicacionapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.colegio.aplicacionapi.models.Practica;

public interface PracticaRepository extends MongoRepository<Practica, String> {

}
