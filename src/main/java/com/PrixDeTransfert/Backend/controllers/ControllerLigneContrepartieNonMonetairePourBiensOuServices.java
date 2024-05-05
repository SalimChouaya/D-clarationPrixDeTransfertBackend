package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;
import com.PrixDeTransfert.Backend.models.LigneContrepartieNonMonetairePourBiensOuServicesBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneContrepartieNonMonetairePourBiensOuServices {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneContrepartieNonMonetairePourBiensOuServices ServiceLigneContrepartieNonMonetairePourBiensOuServices ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurContrepartieNonMonetairePourBiensOuServices/LigneContrepartieNonMonetairePourBiensOuServices")
	public LigneContrepartieNonMonetairePourBiensOuServicesBD save(@RequestBody LigneContrepartieNonMonetairePourBiensOuServicesBD  a,HttpSession session) {
		Long idInformationsSurContrepartieNonMonetairePourBiensOuServices=(Long) session.getAttribute("idInformationsSurContrepartieNonMonetairePourBiensOuServices");
		return ServiceLigneContrepartieNonMonetairePourBiensOuServices.save(a, idInformationsSurContrepartieNonMonetairePourBiensOuServices);}

	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsSurContrepartieNonMonetairePourBiensOuServices InterfaceRepositoryInformationsSurContrepartieNonMonetairePourBiensOuServices;
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
			@PutMapping("/MiseAjourLigneContrepartieNonMonetairePourBiensOuServices")
			public ResponseEntity<String> updateLigneContrepartieNonMonetairePourBiensOuServices(@RequestBody List<LigneContrepartieNonMonetairePourBiensOuServicesBD> updatedLigneContrepartieNonMonetairePourBiensOuServices,HttpSession session) {
			
				Long iddeclaration =(Long) session.getAttribute("Déclarationid");
				DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
				InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
				
				InformationsSurContrepartieNonMonetairePourBiensOuServicesBD InformationsSurContrepartieNonMonetairePourBiensOuServices=InformationsOperations.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire().getInformationsSurContrepartieNonMonetairePourBiensOuServices();
				
				InformationsSurContrepartieNonMonetairePourBiensOuServices.setLigneContrepartieNonMonetairePourBiensOuServices(updatedLigneContrepartieNonMonetairePourBiensOuServices);
				
				InterfaceRepositoryInformationsSurContrepartieNonMonetairePourBiensOuServices.save(InformationsSurContrepartieNonMonetairePourBiensOuServices);
				
				return ResponseEntity.ok(" mise à jour avec succès");
		
			}
		
		
}
