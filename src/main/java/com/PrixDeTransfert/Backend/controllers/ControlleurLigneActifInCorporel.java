package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;

import jakarta.servlet.http.HttpSession;

public class ControlleurLigneActifInCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifInCorporel ServiceLigneActifInCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifInCorporel")
	public LigneActifInCorporelBD save(@RequestBody LigneActifInCorporelBD  a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		return ServiceLigneActifInCorporel.save(a, idInformationsGroupeEntreprises);

}}
