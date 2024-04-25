package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsOperationsFinancieres;
@RestController
public class ControllerInformationsOperationsFinancieres {
	@Autowired
	private ServiceInformationsOperationsFinancieres InformationsOperationsFinancieres ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsOperationsFinancieres/{idMontantTransaction}")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsOperationsFinancieresBD save(@RequestBody InformationsOperationsFinancieresBD  a,@PathVariable("idMontantTransaction") Long idMontantTransaction) {
		return InformationsOperationsFinancieres.save(a, idMontantTransaction);}
}
