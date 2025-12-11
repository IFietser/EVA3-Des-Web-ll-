package com.colegio.aplicacionapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.colegio.aplicacionapi.models.JefeDirecto;

public interface JefeDirectoRepository extends MongoRepository <JefeDirecto, String> {

}
