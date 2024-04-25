package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsAutresOperations;

@RestController
public class ControllerInformationsAutresOperations {
	@Autowired
	private ServiceInformationsAutresOperations InformationsAutresOperations ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsAutresOperations/{idMontantTransaction}")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsAutresOperationsBD save(@RequestBody InformationsAutresOperationsBD a,@PathVariable("idMontantTransaction") Long idMontantTransaction) {
		return InformationsAutresOperations.save(a, idMontantTransaction);}

}
