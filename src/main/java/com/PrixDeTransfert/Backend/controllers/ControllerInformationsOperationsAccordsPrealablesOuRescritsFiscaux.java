package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;

@RestController
public class ControllerInformationsOperationsAccordsPrealablesOuRescritsFiscaux {

	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux;
	
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsOperationsAccordsPrealablesOuRescritsFiscaux/{idInformationsOperations}")
	public InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD save(@RequestBody InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD  a,@PathVariable("idInformationsOperations") Long idInformationsOperations) {
		return ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux.save(a, idInformationsOperations);}

}
