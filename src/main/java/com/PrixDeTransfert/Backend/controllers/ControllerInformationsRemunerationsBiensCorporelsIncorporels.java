package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsRemunerationsBiensCorporelsIncorporels;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerInformationsRemunerationsBiensCorporelsIncorporels {
	@Autowired
	private ServiceInformationsRemunerationsBiensCorporelsIncorporels InformationsRemunerationsBiensCorporelsIncorporels ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsRemunerationsBiensCorporelsIncorporels")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsRemunerationsBiensCorporelsIncorporelsBD save(@RequestBody InformationsRemunerationsBiensCorporelsIncorporelsBD  a,HttpSession session) {
		Long idMontantTransaction=(Long) session.getAttribute("idMontantTransactions");
		InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporelsBD =InformationsRemunerationsBiensCorporelsIncorporels.save(a, idMontantTransaction);
		session.setAttribute("idInformationsRemunerationsBiensCorporelsIncorporels", InformationsRemunerationsBiensCorporelsIncorporelsBD.getId());
		return InformationsRemunerationsBiensCorporelsIncorporelsBD;}

}
