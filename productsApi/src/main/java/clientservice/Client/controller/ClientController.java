package clientservice.Client.controller;

import clientservice.Client.dto.create.CreateClientRequest;
import clientservice.Client.dto.get.GetClientRequest;
import clientservice.Client.dto.get.GetClientResponse;
import clientservice.Client.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    // Atributos
    private ClientService clientService;

    // Construtor
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Métodos
    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @Valid CreateClientRequest request) {
        clientService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponse> getById(GetClientRequest request) {
        GetClientResponse response = clientService.get(request);

        return ResponseEntity.ok(response);
    }
}
