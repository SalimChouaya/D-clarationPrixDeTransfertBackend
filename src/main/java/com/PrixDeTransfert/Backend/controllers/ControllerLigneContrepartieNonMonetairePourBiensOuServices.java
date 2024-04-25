package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneContrepartieNonMonetairePourBiensOuServicesBD;

@RestController
public class ControllerLigneContrepartieNonMonetairePourBiensOuServices {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneContrepartieNonMonetairePourBiensOuServices ServiceLigneContrepartieNonMonetairePourBiensOuServices ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurContrepartieNonMonetairePourBiensOuServices/LigneContrepartieNonMonetairePourBiensOuServices/{idInformationsSurContrepartieNonMonetairePourBiensOuServices}")
	public LigneContrepartieNonMonetairePourBiensOuServicesBD save(@RequestBody LigneContrepartieNonMonetairePourBiensOuServicesBD  a,@PathVariable("idInformationsSurContrepartieNonMonetairePourBiensOuServices") Long idInformationsSurContrepartieNonMonetairePourBiensOuServices) {
		return ServiceLigneContrepartieNonMonetairePourBiensOuServices.save(a, idInformationsSurContrepartieNonMonetairePourBiensOuServices);}


}