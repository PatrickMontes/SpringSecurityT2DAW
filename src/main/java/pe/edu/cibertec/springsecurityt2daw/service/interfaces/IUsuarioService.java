package pe.edu.cibertec.springsecurityt2daw.service.interfaces;

import pe.edu.cibertec.springsecurityt2daw.dto.LoginDTO;
import pe.edu.cibertec.springsecurityt2daw.dto.UsuarioResponseDTO;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;

public interface IUsuarioService {

    UsuarioResponseDTO registrarUsuario(Usuario usuario);
    UsuarioResponseDTO loginUsuario(LoginDTO login);


}
