package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsCessionsAcquisitionsActifs {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsCessionsAcquisitionsActifs ServiceInformationsCessionsAcquisitionsActifs;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsCessionsAcquisitionsActifs")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsCessionsAcquisitionsActifsBD save(@RequestBody InformationsCessionsAcquisitionsActifsBD  a,HttpSession session) {
		Long idMontantTransaction =(Long) session.getAttribute("idMontantTransactions");
		InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifsBD=ServiceInformationsCessionsAcquisitionsActifs.save(a, idMontantTransaction);
		session.setAttribute("idInformationsCessionsAcquisitionsActifs", InformationsCessionsAcquisitionsActifsBD.getId());
		return InformationsCessionsAcquisitionsActifsBD;}

}
