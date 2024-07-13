package com.alura.foro.model;

import com.alura.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicoId;
    private String titulo;
    private LocalDate fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "cursoId")
    private Curso curso;


    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario autor;
}
