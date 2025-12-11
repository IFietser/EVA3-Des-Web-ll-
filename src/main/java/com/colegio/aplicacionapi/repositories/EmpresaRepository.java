package com.colegio.aplicacionapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.colegio.aplicacionapi.models.Empresa;

public interface EmpresaRepository extends MongoRepository <Empresa, String> {

}
