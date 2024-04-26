package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneBiensOuServicesSansContrePartie;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneBiensOuServicesSansContrePartie {
	@Autowired
	private ServiceLigneBiensOuServicesSansContrePartie LigneBiensOuServicesSansContrePartie ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurBiensOuServicesSansContrePartie/LigneBiensOuServicesSansContrePartie ")
	public LigneBiensOuServicesSansContrePartieBD save(@RequestBody LigneBiensOuServicesSansContrePartieBD  a,HttpSession session) {
		Long idInformationsSurBiensOuServicesSansContrePartie=(Long) session.getAttribute("idInformationsSurBiensOuServicesSansContrePartie");
		return LigneBiensOuServicesSansContrePartie.save(a, idInformationsSurBiensOuServicesSansContrePartie);}

}
