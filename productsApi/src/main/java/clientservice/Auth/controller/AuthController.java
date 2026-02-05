package clientservice.Auth.controller;

import clientservice.Auth.dto.login.LoginRequest;
import clientservice.Auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // Atributos
    private AuthService authService;

    // Construtor
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Métodos
    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request) {
        authService.login(request);

        return ResponseEntity.ok().build();
    }
}
