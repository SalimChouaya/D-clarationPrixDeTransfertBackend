package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneService;

@RestController
public class ControllerLigneService {
	@Autowired
	private ServiceLigneService LigneService ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices/LigneService/{idInformationsService}")
	public LigneServiceBD  save(@RequestBody LigneServiceBD  a,@PathVariable("idInformationsService") Long idInformationsService) {
		return LigneService.save(a, idInformationsService);}

}
