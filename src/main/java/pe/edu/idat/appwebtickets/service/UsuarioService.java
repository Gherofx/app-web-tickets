package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Rol;
import pe.edu.idat.appwebtickets.model.bd.Usuario;
import pe.edu.idat.appwebtickets.repository.RolRepository;
import pe.edu.idat.appwebtickets.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();


    public Usuario buscarUsuarioPorCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);

    }

    public Usuario buscarUsuarioPorUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }

    public Usuario guardarUsuario(Usuario usuario){
        usuario.setClave(bCryptPasswordEncoder.encode(usuario.getClave()));
        usuario.setEsactivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }



}
