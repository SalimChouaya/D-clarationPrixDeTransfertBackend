package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
@RestController
public class ControllerInformationsServices {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsServices ServiceInformationsServices  ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices/{idMontantTransaction}")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsServicesBD save(@RequestBody InformationsServicesBD  a,@PathVariable("idMontantTransaction") Long idMontantTransaction) {
		return ServiceInformationsServices.save(a, idMontantTransaction);}
}
