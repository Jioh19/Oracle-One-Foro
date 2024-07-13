package com.alura.foro.service;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }
}
