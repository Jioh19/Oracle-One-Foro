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

    public void actualizarTopico(DtoActualizarTopico datos) {
        if(datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if(datos.status() != null) {
            this.status = datos.status();
        }
        this.fechaCreacion = LocalDate.now();

    }

    public void eliminarTopico() {
        this.status = "cerrado";
    }
}
