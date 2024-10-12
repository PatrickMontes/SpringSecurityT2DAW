package pe.edu.cibertec.springsecurityt2daw.service.interfaces;

import pe.edu.cibertec.springsecurityt2daw.model.Usuario;

public interface IUsuarioService {

    Usuario getUsuarioPorCodigo(String codigo);

}
