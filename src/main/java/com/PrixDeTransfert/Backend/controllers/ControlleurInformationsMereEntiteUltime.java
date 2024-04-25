package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;

@RestController 
public class ControlleurInformationsMereEntiteUltime {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsMereEntiteUltime ServiceInformationsMereEntiteUltime ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/InformationsMereEntiteUltime/{InformationsGroupeEntreprises-id}")
	public InformationsMereEntiteUltimeBD save(@RequestBody InformationsMereEntiteUltimeBD  a,@PathVariable("InformationsGroupeEntreprises-id") Long InformationsGroupeEntreprisesid) {
		return ServiceInformationsMereEntiteUltime.save(a, InformationsGroupeEntreprisesid);
		

}
}