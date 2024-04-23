package br.com.neurotech.challenge.repositories;

import br.com.neurotech.challenge.entity.NeurotechClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NeurotechClientRepository extends JpaRepository<NeurotechClient, Long> {
    Optional<NeurotechClient> findClientById(Long id);
}
