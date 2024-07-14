package com.alura.foro.repository;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
