package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneOperationFinanciereBD;


import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneOperationFinanciere {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneOperationFinanciere ServiceLigneOperationFinanciere ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/MontantTransactions/InformationsOperationsFinancieres/ligneOperationFinanciere")
	public LigneOperationFinanciereBD save(@RequestBody LigneOperationFinanciereBD  a,HttpSession session) {
		Long idInformationsOperationsFinancieres=(Long) session.getAttribute("idInformationsOperationsFinancieres");
		
		
		return ServiceLigneOperationFinanciere.save(a, idInformationsOperationsFinancieres);}

}


