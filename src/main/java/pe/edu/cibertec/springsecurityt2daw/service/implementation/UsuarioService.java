package pe.edu.cibertec.springsecurityt2daw.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
    public Usuario getUsuarioPorCodigo(String codigo) {
        return this.usuarioRepository.findByCodigo(codigo);
    }

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

}
