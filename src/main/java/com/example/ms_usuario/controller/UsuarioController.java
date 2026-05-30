package com.example.ms_usuario.controller;

import com.example.ms_usuario.dto.UsuarioRequestDTO;
import com.example.ms_usuario.dto.UsuarioResponseDTO;
import com.example.ms_usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@Valid @RequestBody UsuarioRequestDTO request){
        return ResponseEntity.status(CREATED)
                .body(usuarioService.createUsuario(request));
    }
    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDTO>>  getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getForId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getForId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> editUsuario(@Valid @RequestBody UsuarioRequestDTO request,@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.editUsuario(request,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
