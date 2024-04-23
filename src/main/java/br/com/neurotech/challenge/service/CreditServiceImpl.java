package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.entity.VehicleModel;

public class CreditServiceImpl  implements CreditService{
    @Override
    public boolean checkCredit(Long clientId, VehicleModel model) {
        return false;
    }
}
