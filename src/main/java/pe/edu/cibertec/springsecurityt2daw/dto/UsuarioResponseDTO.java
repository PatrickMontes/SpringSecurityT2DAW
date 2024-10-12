package pe.edu.cibertec.springsecurityt2daw.dto;

import lombok.Builder;
import lombok.Data;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;

@Data
@Builder
public class UsuarioResponseDTO {

    private Long id;
    private String codigo;
    private String rol;
    private String mensaje;
    private String tiempoExpiracion;
    private String token;
    private Usuario usuario;

}
