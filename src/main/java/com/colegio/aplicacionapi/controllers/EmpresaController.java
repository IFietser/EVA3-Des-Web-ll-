package com.colegio.aplicacionapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.colegio.aplicacionapi.models.Empresa;
import com.colegio.aplicacionapi.requests.EmpresaRequest;
import com.colegio.aplicacionapi.responses.EmpresaResponse;
import com.colegio.aplicacionapi.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> crearEmpresa(@RequestBody EmpresaRequest request) {

        Empresa empresa = new Empresa();
        empresa.setNombre(request.getNombre());
        empresa.setDireccion(request.getDireccion());
        empresa.setTelefono(request.getTelefono());
        empresa.setJefesDirecto(null);
        empresa.setPractica(null);

        Empresa nueva = empresaService.crearEmpresa(empresa);

        EmpresaResponse response = new EmpresaResponse(
                nueva.getId(),
                nueva.getNombre(),
                nueva.getDireccion(),
                nueva.getTelefono()
        );

        return ResponseEntity.status(201).body(response);
    }
}
