package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;

import jakarta.servlet.http.HttpSession;

@RestController 
public class ControlleurInformationsMereEntiteUltime {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsMereEntiteUltime ServiceInformationsMereEntiteUltime ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/InformationsMereEntiteUltime")
	public InformationsMereEntiteUltimeBD save(@RequestBody InformationsMereEntiteUltimeBD  a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		
		return ServiceInformationsMereEntiteUltime.save(a, idInformationsGroupeEntreprises);
		

}
}