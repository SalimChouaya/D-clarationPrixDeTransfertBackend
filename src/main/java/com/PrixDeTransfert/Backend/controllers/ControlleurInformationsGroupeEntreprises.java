package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.RestructurationsGroupeEntreprisesBD;
@RestController
public class ControlleurInformationsGroupeEntreprises {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsGroupeEntreprises ServiceInformationsGroupeEntreprises;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises/{DéclarationPrixDeTransfert-id}")
	public InformationsGroupeEntreprisesBD save(@RequestBody InformationsGroupeEntreprisesBD a,@PathVariable("DéclarationPrixDeTransfert-id") Long idDéclaration) {
		return ServiceInformationsGroupeEntreprises.save(a, idDéclaration);
		
	}
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceRestructurationsGroupeEntreprises ServiceRestructurationsGroupeEntreprises;
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises/RestructurationsGroupeEntreprises/{InformationsGroupeEntreprises-id}")
	public RestructurationsGroupeEntreprisesBD save(@RequestBody RestructurationsGroupeEntreprisesBD a,@PathVariable("InformationsGroupeEntreprises-id") Long idInformationsGroupeEntreprises) {
		return ServiceRestructurationsGroupeEntreprises.save(a, idInformationsGroupeEntreprises);
		
	}
	
	
	
	
	
}
