package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;

public class ControlleurLigneActifInCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifInCorporel ServiceLigneActifInCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifInCorporel/{InformationsGroupeEntreprises-id}")
	public LigneActifInCorporelBD save(@RequestBody LigneActifInCorporelBD  a,@PathVariable("InformationsGroupeEntreprises-id") Long InformationsGroupeEntreprisesid) {
		return ServiceLigneActifInCorporel.save(a, InformationsGroupeEntreprisesid);

}}
