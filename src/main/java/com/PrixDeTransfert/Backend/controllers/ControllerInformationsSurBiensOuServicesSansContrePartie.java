package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;

@RestController
public class ControllerInformationsSurBiensOuServicesSansContrePartie {
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceInformationsSurBiensOuServicesSansContrePartie ServiceInformationsSurBiensOuServicesSansContrePartie;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurBiensOuServicesSansContrePartie/{idInformationsOperations}")
	public InformationsSurBiensOuServicesSansContrePartieBD save(@RequestBody InformationsSurBiensOuServicesSansContrePartieBD  a,@PathVariable("idInformationsOperations") Long idInformationsOperations) {
		return ServiceInformationsSurBiensOuServicesSansContrePartie.save(a, idInformationsOperations);}

}
