package com.alura.foro.domain.topico;

import com.alura.foro.domain.usuario.Usuario;
import com.alura.foro.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

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
    private String mensaje;
    private LocalDate fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "cursoId")
    private Curso curso;


    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario autor;

    public Topico(DtoCrearTopico datos, Usuario autor, Curso curso) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = "pendiente";
        this.autor = autor;
        this.curso = curso;
    }
}
