package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerAutresInformationsARenseignerSurDeclarationPrixTransfert {
	
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert;
	
	@PostMapping("/AutresInformationsARenseignerSurDeclarationPrixTransfert")
	public com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert save(@RequestBody com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert a, HttpSession session) {
		
        Long iddeclaration =(Long) session.getAttribute("Déclarationid");
        
		return ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert.save(a, iddeclaration);
		
	}
	
	
	
	
	

}
