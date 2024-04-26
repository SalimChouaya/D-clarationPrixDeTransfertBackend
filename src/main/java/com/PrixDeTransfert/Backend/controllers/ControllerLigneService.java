package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneService {
	@Autowired
	private ServiceLigneService LigneService ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices/LigneService")
	public LigneServiceBD  save(@RequestBody LigneServiceBD  a,HttpSession session) {
		Long idInformationsService=(Long) session.getAttribute("idInformationsServices");
		return LigneService.save(a, idInformationsService);}

}
