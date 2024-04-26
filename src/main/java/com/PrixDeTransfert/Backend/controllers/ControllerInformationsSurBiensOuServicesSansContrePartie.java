package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsSurBiensOuServicesSansContrePartie {
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceInformationsSurBiensOuServicesSansContrePartie ServiceInformationsSurBiensOuServicesSansContrePartie;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurBiensOuServicesSansContrePartie")
	public InformationsSurBiensOuServicesSansContrePartieBD save(@RequestBody InformationsSurBiensOuServicesSansContrePartieBD  a,HttpSession session) {
		Long idInformationsOperations =(Long) session.getAttribute("idInformationsOperations");
		InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartieBD=ServiceInformationsSurBiensOuServicesSansContrePartie.save(a, idInformationsOperations);
		session.setAttribute("idInformationsSurBiensOuServicesSansContrePartie", InformationsSurBiensOuServicesSansContrePartieBD.getId());
		session.setAttribute("IdOperationsSansContrepartieOuAvecContrepartieNonMonetaire", InformationsSurBiensOuServicesSansContrePartieBD.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire().getId());
		return InformationsSurBiensOuServicesSansContrePartieBD;}

}
