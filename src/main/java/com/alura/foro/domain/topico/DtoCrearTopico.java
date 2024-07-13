package com.alura.foro.domain.topico;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DtoCrearTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String status,
        Long autorId,
        Long cursoId
        ) {
}
