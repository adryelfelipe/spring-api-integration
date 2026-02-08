package clientservice.Auth.controller;

import clientservice.Auth.dto.login.ClientLoginRequest;
import clientservice.Auth.dto.register.ClientRegisterRequest;
import clientservice.Auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestBody @Valid ClientLoginRequest request) {
        String productServiceSessionId = authService.login(request);

        return ResponseEntity.ok().body(productServiceSessionId);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid ClientRegisterRequest request) {
        authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
