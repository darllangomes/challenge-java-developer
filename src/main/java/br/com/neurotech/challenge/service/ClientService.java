package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.DTOS.NeuroTechClientDTO;
import org.springframework.stereotype.Service;

import br.com.neurotech.challenge.entity.NeurotechClient;

import java.util.List;

@Service
public interface ClientService {
	
	/**
	 * Salva um novo cliente
	 * 
	 * @return ID do cliente recém-salvo
	 */
	NeurotechClient save(NeuroTechClientDTO data);
	
	/**
	 * Recupera um cliente baseado no seu ID
	 */
	NeurotechClient get(Long id) throws Exception;
	List<NeurotechClient> getAllClients();
	NeurotechClient updateClient(Long id, NeuroTechClientDTO newData) throws Exception;

}
