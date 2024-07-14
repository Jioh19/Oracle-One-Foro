package com.alura.foro.controller;

import com.alura.foro.domain.topico.DtoActualizarTopico;
import com.alura.foro.domain.topico.DtoCrearTopico;
import com.alura.foro.domain.topico.DtoDetallesTopico;
import com.alura.foro.domain.topico.Topico;
import com.alura.foro.service.CursoService;
import com.alura.foro.service.TopicoService;
import com.alura.foro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

     @Autowired
     private TopicoService topicoService;

     @Autowired
     private UsuarioService usuarioService;

     @Autowired
     private CursoService cursoService;

     @GetMapping("/")
     public ResponseEntity<List<Topico>> findAll(){
         return ResponseEntity.ok(topicoService.findAll());
     }

     @GetMapping("/{id}")
     public ResponseEntity<Topico> findById(@PathVariable("id") Long id){
         var result = topicoService.findById(id);
         if(result.isEmpty()){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(result.get());
     }
     

    @PostMapping("/")
    @Transactional
    public ResponseEntity<Topico> save(@RequestBody @Valid DtoCrearTopico datos, UriComponentsBuilder uriBuilder) {
        var autor = usuarioService.findById(datos.autorId());
        if(autor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var curso = cursoService.findById(datos.cursoId());
        if(curso.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var topico = new Topico(datos, autor.get(), curso.get());
        return ResponseEntity.ok(topicoService.save(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> update(@PathVariable("id") Long id, @RequestBody @Valid DtoActualizarTopico datos){
        var topico = topicoService.findById(id);
        if(topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topico.get().actualizarTopico(datos);


        return ResponseEntity.ok(topico.get());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> delete(@PathVariable("id") Long id) {
        var topico = topicoService.findById(id);
        if(topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topico.get().eliminarTopico();
        return ResponseEntity.ok(topico.get());
    }
}
