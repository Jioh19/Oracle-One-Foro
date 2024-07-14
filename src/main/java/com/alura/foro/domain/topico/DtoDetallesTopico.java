package com.alura.foro.domain.topico;

public record DtoDetallesTopico(String titulo,
                                Long id,
                                String mensaje,
                                String status) {

    public DtoDetallesTopico(Topico topico) {
        this(topico.getTitulo(),
                topico.getTopicoId(),
                topico.getMensaje(),
                topico.getStatus());
    }
}
