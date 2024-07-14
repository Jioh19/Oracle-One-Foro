package com.alura.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoActualizarTopico(
        String titulo,
        String mensaje,
        String status
) {
}
