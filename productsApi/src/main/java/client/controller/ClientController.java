package client.controller;

import client.dto.create.CreateClientRequest;
import client.dto.get.GetClientRequest;
import client.dto.get.GetClientResponse;
import client.service.ClientAppService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    // Atributos
    private ClientAppService clientAppService;

    // Construtor
    public ClientController(ClientAppService clientAppService) {
        this.clientAppService = clientAppService;
    }

    // Métodos
    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @Valid CreateClientRequest request) {
        clientAppService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponse> getById(GetClientRequest request) {
        GetClientResponse response = clientAppService.get(request);

        return ResponseEntity.ok(response);
    }
}
