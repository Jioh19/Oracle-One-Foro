package com.alura.foro.domain.usuario;

import com.alura.foro.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    private String nombre;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    Set<Perfil> perfiles = new HashSet<>();

    public Usuario(DtoCrearUsuario datos, Perfil perfil) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.password = datos.password();
        perfiles.add(perfil);
    }

}
