package pe.edu.cibertec.springsecurityt2daw.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;
import pe.edu.cibertec.springsecurityt2daw.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class DetalleUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByCodigo(username).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        return AuthUsuario.builder()
                .usuario(usuario)
                .build();
    }

}
