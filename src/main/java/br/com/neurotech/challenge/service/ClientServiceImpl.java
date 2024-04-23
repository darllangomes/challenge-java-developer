package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.DTOS.NeuroTechClientDTO;
import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.repositories.NeurotechClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private NeurotechClientRepository repository;

    public void saveClient(NeurotechClient client){
        this.repository.save(client);
    }
    @Override
    public String save(NeuroTechClientDTO data) {
        NeurotechClient client = new NeurotechClient(data);
        this.saveClient(client);
        return client.getId().toString();
    }

    @Override
    public NeurotechClient get(Long id) throws Exception {
        return this.repository.findClientById(id).orElseThrow(() -> new Exception("Cliente não encontrado") );
    }
}