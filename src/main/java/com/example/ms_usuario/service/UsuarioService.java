package com.example.ms_usuario.service;

import com.example.ms_usuario.dto.UsuarioRequestDTO;
import com.example.ms_usuario.dto.UsuarioResponseDTO;
import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    private Usuario getUsuariorTrow(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus
                        .NOT_FOUND,("Usuario no encontrado")));
    }

    public UsuarioResponseDTO createUsuario (UsuarioRequestDTO request){
        Usuario varUsuario = Usuario.builder()
                .nombre(request.getNombre())
                .rut(request.getRut())
                .direccion(request.getDireccion())
                .telefono(request.getTelefono())                
                .build();

        Usuario dbResponse = usuarioRepository.save(varUsuario);

        return UsuarioResponseDTO.builder()
                .id(dbResponse.getId())
                .nombre(request.getNombre())
                .rut(request.getRut())
                .direccion(request.getDireccion())
                .telefono(request.getTelefono())
                .build();
    }
    public List<UsuarioResponseDTO> getAllUsuarios (){
        List <Usuario> usuarioList = usuarioRepository.findAll();
        List <UsuarioResponseDTO> responseList = new ArrayList<>();
        for (Usuario usuario : usuarioList){
            UsuarioResponseDTO response = UsuarioResponseDTO.builder()
                    .nombre(usuario.getNombre())
                    .rut(usuario.getRut())
                    .direccion(usuario.getDireccion())
                    .telefono(usuario.getTelefono())
                    .build();
            responseList.add(response);
        }
        return responseList;
    }
    public UsuarioResponseDTO getForId(Long id){
        Usuario varUsuario = getUsuariorTrow(id);

        return UsuarioResponseDTO.builder()
                .id(varUsuario.getId())
                .nombre(varUsuario.getNombre())
                .rut(varUsuario.getRut())
                .direccion(varUsuario.getDireccion())
                .telefono(varUsuario.getTelefono())
                .build();
    }
    public UsuarioResponseDTO editUsuario(UsuarioRequestDTO request, Long id){
        Usuario varUsuario = getUsuariorTrow(id);
        varUsuario.setNombre(request.getNombre());
        varUsuario.setRut(request.getRut());
        varUsuario.setDireccion(request.getDireccion());
        varUsuario.setTelefono(request.getTelefono());
        usuarioRepository.save(varUsuario);
        return UsuarioResponseDTO.builder()
                .id(varUsuario.getId())
                .nombre(varUsuario.getNombre())
                .rut(varUsuario.getRut())
                .direccion(varUsuario.getDireccion())
                .telefono(varUsuario.getTelefono())
                .build();
    }
    public void deleteUsuario( Long id){
        getUsuariorTrow(id);
        usuarioRepository.deleteById(id);
    }


}
