package com.colegio.aplicacionapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.colegio.aplicacionapi.models.Practica;
import com.colegio.aplicacionapi.responses.GenericResponse;
import com.colegio.aplicacionapi.services.PracticaService;
//Controlador para que los alumnos gestionen sus prácticas 
@RestController
@RequestMapping("/api/estudiantes/practicas")
public class AlumnoController {

    @Autowired
    private PracticaService practicaService;

//registrar práctica
    @PostMapping
    public ResponseEntity<?> crearPractica(@Valid @RequestBody Practica practica) {
        Practica nueva = practicaService.crearPractica(practica);
        return ResponseEntity.status(201).body(nueva);
    }

//ver prácticas
    @GetMapping
    public ResponseEntity<?> obtenerPracticas() {
        List<Practica> practicas = practicaService.obtenerPracticas();
        return ResponseEntity.ok(practicas);
    }
//ver práctica por id
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable String id) {
        Practica practica = practicaService.obtenerPorId(id);

        if (practica == null) {
            return ResponseEntity.status(404).body(new GenericResponse("Práctica no encontrada"));
        }

        return ResponseEntity.ok(practica);
    }
}
