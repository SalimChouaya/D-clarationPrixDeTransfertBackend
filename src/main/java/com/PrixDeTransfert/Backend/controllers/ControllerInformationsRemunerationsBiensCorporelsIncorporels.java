package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsRemunerationsBiensCorporelsIncorporels;
@RestController
public class ControllerInformationsRemunerationsBiensCorporelsIncorporels {
	@Autowired
	private ServiceInformationsRemunerationsBiensCorporelsIncorporels InformationsRemunerationsBiensCorporelsIncorporels ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsRemunerationsBiensCorporelsIncorporels/{idMontantTransaction}")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsRemunerationsBiensCorporelsIncorporelsBD save(@RequestBody InformationsRemunerationsBiensCorporelsIncorporelsBD  a,@PathVariable("idMontantTransaction") Long idMontantTransaction) {
		return InformationsRemunerationsBiensCorporelsIncorporels.save(a, idMontantTransaction);}

}
