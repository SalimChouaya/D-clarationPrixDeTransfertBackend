package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsServicesBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerInformationsServices {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsServices ServiceInformationsServices  ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsServicesBD save(@RequestBody InformationsServicesBD  a,HttpSession session) {
		Long idMontantTransaction =(Long) session.getAttribute("idMontantTransactions");
		InformationsServicesBD informationsServicesBD=ServiceInformationsServices.save(a, idMontantTransaction);
		session.setAttribute("idInformationsServices", informationsServicesBD.getId());
		return informationsServicesBD;}
}
