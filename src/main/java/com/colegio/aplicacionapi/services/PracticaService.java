package com.colegio.aplicacionapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.aplicacionapi.models.Practica;
import com.colegio.aplicacionapi.repositories.PracticaRepository;

@Service
public class PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

//Crear Practica
    public Practica crearPractica(Practica practica) {
        return practicaRepository.save(practica);
    }
//obtener Practica
    public List<Practica> obtenerPracticas() {
        return practicaRepository.findAll();
    }
//Obtener Practica por ID
    public Practica obtenerPorId(String id) {
        return practicaRepository.findById(id).orElse(null);
    }
//Actualizar Practica
    public Practica actualizarPractica(String id, Practica practicaActualizada) {
        Practica existente = obtenerPorId(id);
        if (existente == null) {
            return null;
        }

        existente.setDescripcionActividades(practicaActualizada.getDescripcionActividades());
        existente.setFechaInicio(practicaActualizada.getFechaInicio());
        existente.setFechaTermino(practicaActualizada.getFechaTermino());

        existente.setEstudiante(practicaActualizada.getEstudiante());
        existente.setProfesorSupervisor(practicaActualizada.getProfesorSupervisor());
        existente.setEmpresa(practicaActualizada.getEmpresa());
        existente.setJefeDirecto(practicaActualizada.getJefeDirecto());

        return practicaRepository.save(existente);
    }
//Eliminar Practica
    public void eliminarPractica(String id) {
        practicaRepository.deleteById(id);
    }
}