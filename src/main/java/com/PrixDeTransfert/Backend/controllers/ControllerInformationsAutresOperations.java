package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsAutresOperations;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsAutresOperations {
	@Autowired
	private ServiceInformationsAutresOperations InformationsAutresOperations ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsAutresOperations")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsAutresOperationsBD save(@RequestBody InformationsAutresOperationsBD a,HttpSession session) {
		Long idMontantTransaction =(Long) session.getAttribute("idMontantTransactions");
		InformationsAutresOperationsBD InformationsAutresOperationsBD=InformationsAutresOperations.save(a, idMontantTransaction);
		session.setAttribute("idInformationsAutresOperations", InformationsAutresOperationsBD.getId());
		return InformationsAutresOperationsBD;}

}
