package com.colegio.aplicacionapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.colegio.aplicacionapi.models.Empresa;
import com.colegio.aplicacionapi.models.JefeDirecto;
import com.colegio.aplicacionapi.models.Practica;
import com.colegio.aplicacionapi.requests.EmpresaRequest;
import com.colegio.aplicacionapi.requests.JefeDirectoRequest;
import com.colegio.aplicacionapi.responses.EmpresaResponse;
import com.colegio.aplicacionapi.responses.GenericResponse;
import com.colegio.aplicacionapi.services.EmpresaService;

@RestController
@RequestMapping("/api/profesores/empresas")
public class ProfesorController {

    @Autowired
    private EmpresaService empresaService;

//Crear empresa
    @PostMapping
    public ResponseEntity<?> crearEmpresa(@Valid @RequestBody EmpresaRequest request) {

        Empresa empresa = new Empresa();
        empresa.setNombre(request.getNombre());
        empresa.setDireccion(request.getDireccion());
        empresa.setTelefono(request.getTelefono());

        Empresa nueva = empresaService.crearEmpresa(empresa);

        EmpresaResponse response = new EmpresaResponse(
                nueva.getId(),
                nueva.getNombre(),
                nueva.getDireccion(),
                nueva.getTelefono(),
                "Empresa creada exitosamente"
        );

        return ResponseEntity.status(201).body(response);
    }

//Obtener todas las empresas
    @GetMapping
    public ResponseEntity<?> obtenerTodas() {
    return ResponseEntity.ok(empresaService.obtenerEmpresas());
    }

//Obtener empresa por ID
@GetMapping("/{id}")
public ResponseEntity<?> obtenerPorId(@PathVariable String id) {

    Empresa empresa = empresaService.obtenerPorId(id);

    if (empresa == null) {
        return ResponseEntity.status(404).body(new GenericResponse("Empresa no encontrada"));
    }

    EmpresaResponse response = new EmpresaResponse(
            empresa.getId(),
            empresa.getNombre(),
            empresa.getDireccion(),
            empresa.getTelefono(),
            "Empresa encontrada exitosamente"
    );
    return ResponseEntity.ok(response);
    }

//Actualizar empresa
@PutMapping("/{id}")
public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody EmpresaRequest request) {
    Empresa empresaActualizada = new Empresa();
    empresaActualizada.setNombre(request.getNombre());
    empresaActualizada.setDireccion(request.getDireccion());
    empresaActualizada.setTelefono(request.getTelefono());

    Empresa actualizada = empresaService.actualizarEmpresa(id, empresaActualizada);

    if (actualizada == null) {
        return ResponseEntity.status(404).body(new GenericResponse("Empresa no encontrada"));
    }

    EmpresaResponse response = new EmpresaResponse(
            actualizada.getId(),
            actualizada.getNombre(),
            actualizada.getDireccion(),
            actualizada.getTelefono(),
            "Empresa actualizada exitosamente"
    );

    return ResponseEntity.ok(response);
}
//Eliminar empresa
@DeleteMapping("/{id}")
public ResponseEntity<?> eliminar(@PathVariable String id) {

    Empresa empresa = empresaService.obtenerPorId(id);

    if (empresa == null) {
        return ResponseEntity.status(404).body(new GenericResponse("Empresa no encontrada"));
    }

    empresaService.eliminarEmpresa(id);

    return ResponseEntity.ok(new GenericResponse("Empresa eliminada exitosamente"));
}
//Agregar jefe directo a empresa
@PostMapping("/{id}/jefe")
public ResponseEntity<?> agregarJefe(@PathVariable String id, @Valid @RequestBody JefeDirectoRequest request) {

    JefeDirecto jefe = new JefeDirecto();
    jefe.setNombreCompleto(request.getNombreCompleto());
    jefe.setEmail(request.getEmail());
    jefe.setTelefono(request.getTelefono());

    Empresa empresa = empresaService.agregarJefeDirecto(id, jefe);

    if (empresa == null) {
        return ResponseEntity.status(404)
                .body(new GenericResponse("Empresa no encontrada"));
    }

    return ResponseEntity.ok(new GenericResponse("Jefe Directo agregado correctamente"));
}
//Agregar Practica a la empresa
@PostMapping("/{id}/practica")
public ResponseEntity<?> agregarPractica(@PathVariable String id, @RequestBody Practica practica) {

    Empresa empresa = empresaService.agregarPractica(id, practica);

    if (empresa == null) {
        return ResponseEntity.status(404)
                .body(new GenericResponse("Empresa no encontrada"));
    }

    return ResponseEntity.ok(new GenericResponse("Práctica agregada correctamente"));
    }
}
