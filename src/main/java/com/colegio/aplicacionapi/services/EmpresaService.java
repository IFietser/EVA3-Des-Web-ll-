package com.colegio.aplicacionapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.colegio.aplicacionapi.models.Empresa;
import com.colegio.aplicacionapi.models.JefeDirecto;
import com.colegio.aplicacionapi.models.Practica;
import com.colegio.aplicacionapi.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    public EmpresaRepository empresaRepository;
//Crear Empresa
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
//Obtener todas las Empresas
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }
//Obtener Empresa por ID
    public Empresa obtenerPorId(String id) {
        return empresaRepository.findById(id).orElse(null);
    }
//Actualizar Empresa
 public Empresa actualizarEmpresa(String id, Empresa empresaActualizada) {
        Empresa existente = obtenerPorId(id);
        if (existente == null) {
            return null;
        }
        existente.setNombre(empresaActualizada.getNombre());
        existente.setDireccion(empresaActualizada.getDireccion());
        existente.setTelefono(empresaActualizada.getTelefono());
        existente.setJefesDirecto(empresaActualizada.getJefesDirecto());
        existente.setPractica(empresaActualizada.getPractica());

        return empresaRepository.save(existente);
    }
//Eliminar Empresa
    public void eliminarEmpresa(String id) {
        empresaRepository.deleteById(id);
    }
//Agregar Jefe Directo a Empresa
    public Empresa agregarJefeDirecto(String empresaId, JefeDirecto jefe) {
        Empresa empresa = obtenerPorId(empresaId);
        if (empresa == null) {
        return null;
        }

        empresa.getJefesDirecto().add(jefe);
        return empresaRepository.save(empresa);
    }
//Agregar practica a Empresa
public Empresa agregarPractica(String empresaId, Practica practica) {
        Empresa empresa = obtenerPorId(empresaId);
        if (empresa == null) {
            return null;
        }
        empresa.getPractica().add(practica);
        return empresaRepository.save(empresa);
    }

}
