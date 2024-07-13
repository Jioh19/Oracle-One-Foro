package com.alura.foro.domain.perfil;

import com.alura.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfilId;
    private String nombre;

    public Perfil(String s) {
        this.nombre = s;
    }
}
