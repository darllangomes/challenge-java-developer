package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.entity.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    ClientService clientService;
    @Override
    public boolean checkCredit(Long clientId, VehicleModel model) throws Exception {

        NeurotechClient client = clientService.get(clientId);

        if(client.getIncome() >= 5000 && client.getIncome() <= 15000 && model.equals(VehicleModel.HATCH)){
            return true;
        }else return client.getAge() > 20 && client.getIncome() > 8000 && model.equals(VehicleModel.SUV);
    }
}
