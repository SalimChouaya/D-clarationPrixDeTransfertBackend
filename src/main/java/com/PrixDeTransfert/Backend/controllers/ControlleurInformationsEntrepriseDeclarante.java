package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.ChangementsActiviteAucoursExerciceBD;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.Qualité;
@RestController
public class ControlleurInformationsEntrepriseDeclarante {
	
	
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceInformationsEntrepriseDeclarante ServiceInformationsEntrepriseDeclarante;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/{DéclarationPrixDeTransfert-id}")
		public InformationsEntrepriseDeclaranteBD save(@RequestBody InformationsEntrepriseDeclaranteBD  a,@PathVariable("DéclarationPrixDeTransfert-id") Long idDéclaration) {
			return ServiceInformationsEntrepriseDeclarante.save(a, idDéclaration);
			
		}
		
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceQualité ServiceQualité;
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/qualité/{InformationsEntrepriseDeclarante-id}")
		public Qualité save(@RequestBody Qualité  a,@PathVariable("InformationsEntrepriseDeclarante-id") Long InformationsEntrepriseDeclaranteid) {
			return ServiceQualité.save(a, InformationsEntrepriseDeclaranteid);
			
		}
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceChangementsActiviteAucoursExercice ServiceChangementsActiviteAucoursExercice;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/ChangementsActiviteAucoursExercice/{InformationsEntrepriseDeclarante-id}")
		public ChangementsActiviteAucoursExerciceBD save(@RequestBody ChangementsActiviteAucoursExerciceBD  a,@PathVariable("InformationsEntrepriseDeclarante-id") Long InformationsEntrepriseDeclaranteid) {
			return ServiceChangementsActiviteAucoursExercice.save(a, InformationsEntrepriseDeclaranteid);
		
		}
		
		
}
