package productservice.Auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import productservice.Auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // Atributos
    private AuthService authService;

    // Construtor
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Endpoints
    @PostMapping()
    public ResponseEntity<String> authenticate(@RequestParam String password,@RequestParam Long clientId ,HttpSession session) {
        authService.authenticate(password, clientId);

        return ResponseEntity.ok().body(session.getId());
    }
}
