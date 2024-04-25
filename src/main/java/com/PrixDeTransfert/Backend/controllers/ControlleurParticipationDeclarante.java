package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;

@RestController
public class ControlleurParticipationDeclarante {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceParticipationDeclarante ServiceParticipationDeclarante ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/LigneParticipationDeclarante/{InformationsEntrepriseDeclarante-id}")
	public LigneParticipationDeclaranteBD save(@RequestBody LigneParticipationDeclaranteBD  a,@PathVariable("InformationsEntrepriseDeclarante-id") Long InformationsEntrepriseDeclaranteid) {
		return ServiceParticipationDeclarante.save(a, InformationsEntrepriseDeclaranteid);
		

}
}