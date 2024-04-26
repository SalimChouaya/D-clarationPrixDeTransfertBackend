package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurLigneActifCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifCorporel ServiceLigneActifCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifCorporel")
	public LigneActifCorporelBD save(@RequestBody LigneActifCorporelBD  a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		return ServiceLigneActifCorporel.save(a, idInformationsGroupeEntreprises);
}}
