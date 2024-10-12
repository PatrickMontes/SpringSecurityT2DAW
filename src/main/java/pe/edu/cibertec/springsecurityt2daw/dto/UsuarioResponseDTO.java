package pe.edu.cibertec.springsecurityt2daw.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDTO {

    private Long id;
    private String codigo;
    private String token;

}
