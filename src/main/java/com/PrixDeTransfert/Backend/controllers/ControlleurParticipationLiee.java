package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurParticipationLiee {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceParticipationLiee ServiceParticipationLiee ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/LigneParticipationLiee")
	
	public LigneParticipationLieeBD save(@RequestBody LigneParticipationLieeBD a,HttpSession session) {
		Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
		return ServiceParticipationLiee.save(a, InformationsEntrepriseDeclaranteid);
		
	}
}


