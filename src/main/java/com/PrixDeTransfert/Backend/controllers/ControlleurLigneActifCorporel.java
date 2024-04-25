package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;
@RestController
public class ControlleurLigneActifCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifCorporel ServiceLigneActifCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifCorporel/{InformationsGroupeEntreprises-id}")
	public LigneActifCorporelBD save(@RequestBody LigneActifCorporelBD  a,@PathVariable("InformationsGroupeEntreprises-id") Long InformationsGroupeEntreprisesid) {
		return ServiceLigneActifCorporel.save(a, InformationsGroupeEntreprisesid);
}}
