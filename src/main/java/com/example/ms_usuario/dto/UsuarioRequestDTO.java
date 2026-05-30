package com.example.ms_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String rut;
    @NotBlank
    private String direccion;
    @NotBlank
    private String telefono;
}
