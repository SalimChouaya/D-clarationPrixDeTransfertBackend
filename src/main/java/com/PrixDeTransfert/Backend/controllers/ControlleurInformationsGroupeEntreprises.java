package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.RestructurationsGroupeEntreprisesBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurInformationsGroupeEntreprises {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsGroupeEntreprises ServiceInformationsGroupeEntreprises;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises")
	public InformationsGroupeEntreprisesBD save(@RequestBody InformationsGroupeEntreprisesBD a,HttpSession session) {
		Long declarationid =(Long) session.getAttribute("Déclarationid");
	    InformationsGroupeEntreprisesBD InformationsGroupeEntrepriseBD=ServiceInformationsGroupeEntreprises.save(a, declarationid);
		session.setAttribute("idInformationsGroupeEntreprises",InformationsGroupeEntrepriseBD.getId() );
		return InformationsGroupeEntrepriseBD;
		
	}
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceRestructurationsGroupeEntreprises ServiceRestructurationsGroupeEntreprises;
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises/RestructurationsGroupeEntreprises")
	public RestructurationsGroupeEntreprisesBD save(@RequestBody RestructurationsGroupeEntreprisesBD a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		return ServiceRestructurationsGroupeEntreprises.save(a, idInformationsGroupeEntreprises);
		
	}
	
	
	
	
	
}
