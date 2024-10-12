package pe.edu.cibertec.springsecurityt2daw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.springsecurityt2daw.dto.LoginDTO;
import pe.edu.cibertec.springsecurityt2daw.dto.UsuarioResponseDTO;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;
import pe.edu.cibertec.springsecurityt2daw.service.implementation.UsuarioService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponseDTO> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }


    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(usuarioService.loginUsuario(loginDTO));
    }

}
