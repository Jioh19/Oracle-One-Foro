package com.alura.foro.domain.respuesta;

import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long respuestaId;
    private String mensaje;
    private LocalDate fechaCreacion;
    private String solucion;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "topicoId")
    private Topico topico;
}
