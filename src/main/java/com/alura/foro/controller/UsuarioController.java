package com.alura.foro.controller;

import com.alura.foro.domain.perfil.Perfil;
import com.alura.foro.domain.usuario.DtoCrearUsuario;
import com.alura.foro.domain.usuario.Usuario;
import com.alura.foro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> save(@RequestBody @Valid DtoCrearUsuario datos, UriComponentsBuilder uriBuilder) {
        var perfil = new Perfil(datos.userName());
        var usuario = new Usuario(datos, perfil);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
}
