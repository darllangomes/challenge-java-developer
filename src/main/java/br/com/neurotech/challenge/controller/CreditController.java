package br.com.neurotech.challenge.controller;


import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.entity.VehicleModel;
import br.com.neurotech.challenge.service.ClientService;
import br.com.neurotech.challenge.service.CreditService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {


    @Autowired
    CreditService creditService;

    @GetMapping("/{id}/{modelStr}")
    public ResponseEntity<String> checkCredit(@PathVariable Long id, @PathVariable String modelStr) {
        try {
            VehicleModel model = VehicleModel.valueOf(modelStr.toUpperCase()); // Convertendo a string para o tipo enumerado VehicleModel
            boolean response = creditService.checkCredit(id, model);

            if (response) {
                return new ResponseEntity<>("Liberado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Não liberado", HttpStatus.OK);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Modelo de veículo inválido", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
