package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.ChangementsActiviteAucoursExerciceBD;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.ModificationLiensCapitalAuCoursExerciceBD;
import com.PrixDeTransfert.Backend.models.Qualité;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurInformationsEntrepriseDeclarante {
	
	
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceInformationsEntrepriseDeclarante ServiceInformationsEntrepriseDeclarante;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante")
		public InformationsEntrepriseDeclaranteBD save(@RequestBody InformationsEntrepriseDeclaranteBD  a,HttpSession session) {
			Long declarationid =(Long) session.getAttribute("Déclarationid");
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclaranteBD=ServiceInformationsEntrepriseDeclarante.save(a, declarationid);
			session.setAttribute("InformationsEntrepriseDeclaranteid",InformationsEntrepriseDeclaranteBD.getId() );
			return InformationsEntrepriseDeclaranteBD ;
			
		}
		
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceQualité ServiceQualité;
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/qualité")
		public Qualité save(@RequestBody Qualité  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			
			return ServiceQualité.save(a, InformationsEntrepriseDeclaranteid);
			
		}
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceChangementsActiviteAucoursExercice ServiceChangementsActiviteAucoursExercice;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/ChangementsActiviteAucoursExercice")
		public ChangementsActiviteAucoursExerciceBD save(@RequestBody ChangementsActiviteAucoursExerciceBD  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			return ServiceChangementsActiviteAucoursExercice.save(a, InformationsEntrepriseDeclaranteid);
		
		}
		
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceModificationLiensCapitalAuCoursExercice ServiceModificationLiensCapitalAuCoursExercice;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/ModificationLiensCapitalAuCoursExercice")
		public ModificationLiensCapitalAuCoursExerciceBD save(@RequestBody ModificationLiensCapitalAuCoursExerciceBD  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			return ServiceModificationLiensCapitalAuCoursExercice.save(a, InformationsEntrepriseDeclaranteid);
		
		}
}
