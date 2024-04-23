package br.com.neurotech.challenge;

import br.com.neurotech.challenge.DTOS.NeuroTechClientDTO;
import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;
    @PostMapping
    public ResponseEntity<NeurotechClient> createClient(@RequestBody NeuroTechClientDTO client){
        NeurotechClient newClient = clientService.save(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NeurotechClient>> getAllClients(){
        List<NeurotechClient> allClients = this.clientService.getAllClients();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }
}
