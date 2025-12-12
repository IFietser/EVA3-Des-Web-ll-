package com.colegio.aplicacionapi.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JefeDirectoRequest {

    @NotBlank(message = "El nombre completo no puede estar vacío")
    @Size(min = 5, max = 80, message = "El nombre completo debe tener entre 5 y 80 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9+\\-\\s]{8,15}$", message = "El teléfono debe tener entre 8 y 15 dígitos (puede incluir +, - o espacios)")
    private String telefono;
}
