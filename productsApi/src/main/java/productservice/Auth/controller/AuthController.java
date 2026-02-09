package productservice.Auth.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> authenticate(@RequestParam String password, @RequestParam Long clientId, @RequestHeader("Cookie") String client_service_sessionId, HttpSession session) {
        authService.authenticate(password, clientId, client_service_sessionId);

        return ResponseEntity.ok().body(session.getId());
    }
}
