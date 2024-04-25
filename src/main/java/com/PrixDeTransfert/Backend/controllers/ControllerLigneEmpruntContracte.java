package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;

@RestController
public class ControllerLigneEmpruntContracte
{
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneEmpruntContracte ServiceLigneEmpruntContracte ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsPretsEmprunts/LigneEmpruntContracte/{idInformationsPretsEmprunts}")// lid nekhdhouh mn lignePretAccorde baad mancreew InormationsEmprunts
	public LigneEmpruntContracteBD save(@RequestBody LigneEmpruntContracteBD  a,@PathVariable("idInformationsPretsEmprunts") Long idInformationsPretsEmprunts) {
		return ServiceLigneEmpruntContracte.save(a, idInformationsPretsEmprunts);}

	

}
