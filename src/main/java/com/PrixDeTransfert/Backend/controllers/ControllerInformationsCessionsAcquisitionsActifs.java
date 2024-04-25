package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;

@RestController
public class ControllerInformationsCessionsAcquisitionsActifs {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsCessionsAcquisitionsActifs ServiceInformationsCessionsAcquisitionsActifs;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsCessionsAcquisitionsActifs/{idMontantTransaction}")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsCessionsAcquisitionsActifsBD save(@RequestBody InformationsCessionsAcquisitionsActifsBD  a,@PathVariable("idMontantTransaction") Long idMontantTransaction) {
		return ServiceInformationsCessionsAcquisitionsActifs.save(a, idMontantTransaction);}

}
