package pe.edu.cibertec.springsecurityt2daw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.cibertec.springsecurityt2daw.enums.Rol;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Boolean activo;

}
