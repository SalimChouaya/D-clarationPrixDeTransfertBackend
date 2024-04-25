package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;

@RestController
public class ControllerLignePretAccorde {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLignePretAccorde ServiceLignePretAccorde;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsPretsEmprunts/LignePretAccorde/{idInformationsOperations}")// lid nekhdhouh waktli nasn3o awel mara InformationsOperations f valeur Exploitation 
	public LignePretAccordeBD save(@RequestBody LignePretAccordeBD  a,@PathVariable("idInformationsOperations") Long idInformationsOperations) {
		return ServiceLignePretAccorde.save(a, idInformationsOperations);}

	

}
