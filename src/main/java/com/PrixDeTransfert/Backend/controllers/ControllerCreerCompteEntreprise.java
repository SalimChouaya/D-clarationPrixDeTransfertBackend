package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.PrixDeTransfert.Backend.models.*;

import jakarta.servlet.http.HttpSession;


@RestController
public class ControllerCreerCompteEntreprise {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceCreerCompte ServiceCreerCompte;
	
	@PostMapping("/Entreprise")
	public com.PrixDeTransfert.Backend.models.Entreprise save(@RequestBody com.PrixDeTransfert.Backend.models.Entreprise a, HttpSession session) {
		Entreprise savedEntreprise = ServiceCreerCompte.save(a);
        session.setAttribute("entrepriseId", savedEntreprise.getId());
		return savedEntreprise;
		
	}
	@GetMapping("/Entreprise/{id}")
	public Entreprise findbymatricule(@PathVariable("id") Long id) {
		return ServiceCreerCompte.findEntrepriseById(id);
	}
}
