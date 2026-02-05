package clientservice.Client.controller;

<<<<<<< HEAD
import clientservice.Auth.exception.AccessDeniedException;
=======
>>>>>>> 56bcd452db047ecf3366af2df8f774fdba689bc7
import clientservice.Client.dto.create.CreateClientRequest;
import clientservice.Client.dto.get.GetClientRequest;
import clientservice.Client.dto.get.GetClientResponse;
import clientservice.Client.service.ClientService;
<<<<<<< HEAD
import clientservice.infra.session.ClientSession;
=======
>>>>>>> 56bcd452db047ecf3366af2df8f774fdba689bc7
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    // Atributos
    private ClientService clientService;
    private ClientSession clientSession;

    // Construtor
    public ClientController(ClientService clientService, ClientSession clientSession) {
        this.clientService = clientService;
        this.clientSession = clientSession;
    }

    // Métodos
    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @Valid CreateClientRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        clientService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponse> getById(GetClientRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        GetClientResponse response = clientService.get(request);

        return ResponseEntity.ok(response);
    }
}
