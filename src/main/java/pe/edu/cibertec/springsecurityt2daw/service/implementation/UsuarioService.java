package pe.edu.cibertec.springsecurityt2daw.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;
import pe.edu.cibertec.springsecurityt2daw.repository.UsuarioRepository;
import pe.edu.cibertec.springsecurityt2daw.service.interfaces.IUsuarioService;


@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuarioPorCodigo(String codigo) {
        return this.usuarioRepository.findByCodigo(codigo);
    }

}
