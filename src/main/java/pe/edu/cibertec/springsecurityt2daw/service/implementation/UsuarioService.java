package pe.edu.cibertec.springsecurityt2daw.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.springsecurityt2daw.dto.LoginDTO;
import pe.edu.cibertec.springsecurityt2daw.dto.UsuarioResponseDTO;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;
import pe.edu.cibertec.springsecurityt2daw.repository.UsuarioRepository;
import pe.edu.cibertec.springsecurityt2daw.service.interfaces.IUsuarioService;


@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UsuarioResponseDTO registrarUsuario(Usuario usuario) {
        usuario.setCodigo(passwordEncoder.encode(usuario.getCodigo()));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario usuarioSaved = this.usuarioRepository.save(usuario);

        return UsuarioResponseDTO.builder()
                .mensaje("Usuario registrado")
                .codigo(usuarioSaved.getCodigo())
                .build();
    }


    @Override
    public UsuarioResponseDTO loginUsuario(LoginDTO login) {
        Usuario usuario = this.usuarioRepository.findByCodigo(login.getCodigo()).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        if (!passwordEncoder.matches(login.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        if(!passwordEncoder.matches(login.getCodigo(), usuario.getCodigo())) {
            throw new RuntimeException("Codigo incorrecta");
        }

        //String token = this.jwtUtil.generarToken(usuario);

        return UsuarioResponseDTO.builder()
                .mensaje("Usuario logeado correctamente")
                .codigo(usuario.getCodigo())
                .tiempoExpiracion("3 minutos")
                //.token(token)
                .build();
    }

}
