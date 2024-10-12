package pe.edu.cibertec.springsecurityt2daw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.springsecurityt2daw.dto.LoginDTO;
import pe.edu.cibertec.springsecurityt2daw.dto.UsuarioResponseDTO;
import pe.edu.cibertec.springsecurityt2daw.model.Usuario;
import pe.edu.cibertec.springsecurityt2daw.service.implementation.UsuarioService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(usuarioService.loginUsuario(loginDTO));
    }


    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponseDTO> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }


    @GetMapping("/obtener/{codigo}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(usuarioService.getUsuarioPorCodigo(codigo));
    }


    @PreAuthorize("hasRole('GESTOR') or hasRole('COORDINADOR')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuarioResponseDTO> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.editarUsuario(id, usuario));
    }

}
