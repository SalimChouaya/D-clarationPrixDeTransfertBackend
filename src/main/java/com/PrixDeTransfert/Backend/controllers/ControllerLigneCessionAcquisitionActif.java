package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneCessionAcquisitionActif;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerLigneCessionAcquisitionActif {
	@Autowired
	private ServiceLigneCessionAcquisitionActif LigneCessionAcquisitionActif ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsCessionsAcquisitionsActifs/LigneCessionAcquisitionActif")
	public LigneCessionAcquisitionActifBD save(@RequestBody LigneCessionAcquisitionActifBD a,HttpSession session) {
		Long idInformationsCessionsAcquisitionsActifs=(Long) session.getAttribute("idInformationsCessionsAcquisitionsActifs");
		
		return LigneCessionAcquisitionActif.save(a, idInformationsCessionsAcquisitionsActifs);}

}
