package com.PrixDeTransfert.Backend.controllers;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert;
import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.Entreprise;
import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;
import com.PrixDeTransfert.Backend.models.InformationsValeursExploitationBD;
import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;
import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;
import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;
import com.PrixDeTransfert.Backend.models.LigneBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.models.LigneContrepartieNonMonetairePourBiensOuServicesBD;
import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;
import com.PrixDeTransfert.Backend.models.LigneOperationFinanciereBD;
import com.PrixDeTransfert.Backend.models.LigneOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;
import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;
import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.models.LigneValeurExploitationBD;
import com.PrixDeTransfert.Backend.models.ModificationLiensCapitalAuCoursExerciceBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.models.OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD;
import com.PrixDeTransfert.Backend.models.Qualité;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ActifIncorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.Actifcorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.AutreIdentifiant;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ChangementMethodePrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ChangementsActiviteAuCoursExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.DateFinExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.Entete;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.IdentifiantEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.IdentificationEntrepriseDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsAutresOperations;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsCessionsAcquisitionsActifs;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsEntiteMereUltime;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsEntrepriseDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsGroupeEntreprises;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperations;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperationsFinancieres;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsPretsEmprunts;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsRemunerationsBiensCorporelsIncorporels;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsSurBiensOuServicesSansContrePartie;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsSurContrepartieNonMonetairePourBiensOuServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsValeursExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LiensCapital;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneActifCorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneActifIncorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneAutreOperation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneBiensOuServicesSansContrePartie;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneCessionAcquisitionActif;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneContrepartieNonMonetairePourBiensOuServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneEmpruntContracte;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneOperationFinanciere;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneOperationsAccordsPrealablesOuRescritsFiscaux;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneParticipationDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneParticipationLiee;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LignePretAccorde;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneRemunerationsBiens;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneService;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneValeurExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.MethodePrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ModificationLiensCapitalAuCoursExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.MontantTransactionsMethodeDeterminationPrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureAutreOperation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationCessionAcquisitionActif;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationFinanciere;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationRemunerationBiens;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationService;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationValeurExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureRelationEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.PrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.QualiteEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.QualiteEntrepriseDeclarante;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
@RestController
public class ControlleurFichierXML {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;

	    @GetMapping("/download/xml/{idEntreprise}")
	    public ResponseEntity<String> downloadXml(@PathVariable("idEntreprise") Long id) {
	        try {
	            com.PrixDeTransfert.Backend.structureXML.GenerationXML.PrixTransfert prixTransfert = createPrixTransfert(id); // Méthode à définir pour créer et remplir l'objet
	            XmlMapper xmlMapper = new XmlMapper();
	            xmlMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
	            StringWriter writer = new StringWriter();
	            xmlMapper.writeValue(writer, prixTransfert);
	            
	            String xmlContent = writer.toString();
	            return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"prix_transfert.xml\"")
	                .contentType(MediaType.APPLICATION_XML)
	                .body(xmlContent);
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Error generating XML: " + e.getMessage());
	        }
	    }

	    private PrixTransfert createPrixTransfert(Long id) {
	    	
	    	PrixTransfert prixTransfert = new PrixTransfert();
	    	Entreprise Entreprise=InterfaceRepositoryCreerCompte.findEntrepriseById(id);
	    	DéclarationPrixDeTransfert DéclarationPrixDeTransfert=Entreprise.getDéclarationPrixDeTransfert();
	        prixTransfert.setEntete(new Entete());
	        prixTransfert.getEntete().setCodeActe(DéclarationPrixDeTransfert.getCodeActe());
	        prixTransfert.getEntete().setExercice(DéclarationPrixDeTransfert.getExercice());
	        prixTransfert.getEntete().setMatriculeFiscalDeclarant(DéclarationPrixDeTransfert.getMatriculeFiscalDeclarant());
	        prixTransfert.getEntete().setCodeTVA(DéclarationPrixDeTransfert.getCodeTva());
	        prixTransfert.getEntete().setCodeCategorie(DéclarationPrixDeTransfert.getCodeCatégorie());
	        prixTransfert.getEntete().setTypeDeclaration(DéclarationPrixDeTransfert.getTypeDéclaration());
	        prixTransfert.getEntete().setDateDebutExercice(DéclarationPrixDeTransfert.getDateDébutExercice());
	        prixTransfert.getEntete().setDateFinExercice(new DateFinExercice());
	        prixTransfert.getEntete().getDateFinExercice().setNatureDateFin(1);
	        prixTransfert.getEntete().getDateFinExercice().setValue(DéclarationPrixDeTransfert.getDateFinExercice());
	       
	        IdentificationEntrepriseDeclarante ident = new IdentificationEntrepriseDeclarante();
	        ident.setRaisonSociale(Entreprise.getRaisonSocial());
	        ident.setFormeJuridique(Entreprise.getFormeJuridique());
	        ident.setNationalite(Entreprise.getNationalite());
	        ident.setAdresseSiegeSocialEtablissementTunisie(Entreprise.getAdresseSiegeSocialEtablissementTunisie());
	        ident.setCodePostal(Entreprise.getCodePostal());
	        ident.setActivitePrincipale(Entreprise.getActivitePrincipale());
	        ident.setActiviteSecondaire(Entreprise.getActiviteSecondaire());
	        ident.setChiffreAffaireAnnuel(5000000.00);

	        prixTransfert.setIdentificationEntrepriseDeclarante(ident);
	        
	        
	        InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclaranteBD= DéclarationPrixDeTransfert.getInformationsEntrepriseDeclarante();
	        InformationsEntrepriseDeclarante infos = new InformationsEntrepriseDeclarante();
	        QualiteEntrepriseDeclarante qualite = new QualiteEntrepriseDeclarante();
	        List<Qualité> qualitésInformations = InformationsEntrepriseDeclaranteBD.getQualité();
	        List<Integer> qualites = new ArrayList<>();
	        if (qualitésInformations !=null && !qualitésInformations.isEmpty() ) {
	        for (int i = 0; i < qualitésInformations.size(); i++) {
	            
	            Qualité qualité = qualitésInformations.get(i); 
	            qualites.add(qualité.getQualité()); 
	            
	        }
	        infos.setQualiteEntrepriseDeclarante(qualite);
	        infos.getQualiteEntrepriseDeclarante().setQualites(qualites);
	        }else {infos.setQualiteEntrepriseDeclarante(qualite);
	        	infos.getQualiteEntrepriseDeclarante().setAutreQualite(InformationsEntrepriseDeclaranteBD.getAutreQualité());
	        }
	        infos.setDescriptionActivitesPrincipales(InformationsEntrepriseDeclaranteBD.getDescriptionActivitesPrincipales());
	        
	        infos.setChangementsActiviteAuCoursExercice(new ChangementsActiviteAuCoursExercice());
	        infos.getChangementsActiviteAuCoursExercice().setAffirmation(InformationsEntrepriseDeclaranteBD.getChangementsActiviteAucoursExercice().getAffirmation());
	        infos.getChangementsActiviteAuCoursExercice().setDescription(InformationsEntrepriseDeclaranteBD.getChangementsActiviteAucoursExercice().getDescription());
	        
	        LiensCapital liensCapital = new LiensCapital();
	       
	        List<LigneParticipationLieeBD> LigneParticipationLieeBD=InformationsEntrepriseDeclaranteBD.getLigneParticipationLiee();
	        List<LigneParticipationLiee> Liste =new ArrayList<>();
	        for (int i=0; i < LigneParticipationLieeBD.size();i++) {
	        	LigneParticipationLiee LigneparticipationLiee = new LigneParticipationLiee();
		        IdentifiantEntreprise identifiant = new IdentifiantEntreprise();
		        QualiteEntreprise qualitee = new QualiteEntreprise();
	        if(LigneParticipationLieeBD.get(i).getMatriculeFiscal()!=null  && !LigneParticipationLieeBD.get(i).getMatriculeFiscal().isEmpty()) {
	        identifiant.setMatriculeFiscal(LigneParticipationLieeBD.get(i).getMatriculeFiscal());
	        }
	        else  {identifiant.setAutreIdentifiant(new AutreIdentifiant());
	        	identifiant.getAutreIdentifiant().setEtatTerritoire(LigneParticipationLieeBD.get(i).getEtatTerritoire());
	        identifiant.getAutreIdentifiant().setIdentifiant(LigneParticipationLieeBD.get(i).getIdentifiant());
	        }
	        LigneparticipationLiee.setIdentifiantEntreprise(identifiant);
	        LigneparticipationLiee.setRaisonSociale(LigneParticipationLieeBD.get(i).getRaisonSociale());
	        if (LigneParticipationLieeBD.get(i).getQualité()!=null &&  !LigneParticipationLieeBD.get(i).getQualité().isEmpty()) {
	        	qualitee.setQualite(Integer.parseInt(LigneParticipationLieeBD.get(i).getQualité()));
	        	
	        }
	        else {
	        	qualitee.setAutreQualité(LigneParticipationLieeBD.get(i).getQualitéEntreprise());
	        } 
	        LigneparticipationLiee.setQualiteEntreprise(qualitee);
	        LigneparticipationLiee.setPourcentageDetentionCapital(LigneParticipationLieeBD.get(i).getPourcentageDetentionCapital());
	        LigneparticipationLiee.setPourcentageDetentionDroitsVote(LigneParticipationLieeBD.get(i).getPourcentageDetentionDroitsVote());
	        Liste.add(LigneparticipationLiee);
	        }
	        liensCapital.setParticipationLiee(Liste);
	        
	        List<LigneParticipationDeclaranteBD> LigneParticipationDeclaranteBD=InformationsEntrepriseDeclaranteBD.getLigneParticipationDeclarante();
	        List<LigneParticipationDeclarante> ListeDeclarante =new ArrayList<>();
	        for (int i=0; i <LigneParticipationDeclaranteBD.size();i++) {
	        	LigneParticipationDeclarante LigneparticipationDeclarante = new LigneParticipationDeclarante();
		        IdentifiantEntreprise identifiantDeclarant = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteDeclarante = new QualiteEntreprise();
		        if(LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal()!=null && !LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal().isEmpty()) {
			        identifiantDeclarant.setMatriculeFiscal(LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantDeclarant.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantDeclarant.getAutreIdentifiant().setEtatTerritoire(LigneParticipationDeclaranteBD.get(i).getEtatTerritoire());
			        identifiantDeclarant.getAutreIdentifiant().setIdentifiant(LigneParticipationDeclaranteBD.get(i).getIdentifiant());
			        }
	        
		        LigneparticipationDeclarante.setIdentifiantEntreprise(identifiantDeclarant);
		        LigneparticipationDeclarante.setRaisonSociale(LigneParticipationDeclaranteBD.get(i).getRaisonSociale());
	        
		        if (LigneParticipationDeclaranteBD.get(i).getQualité()!=null &&  !LigneParticipationDeclaranteBD.get(i).getQualité().isEmpty()) {
		        	qualiteDeclarante.setQualite(Integer.parseInt(LigneParticipationDeclaranteBD.get(i).getQualité()));
		        	
		        }
		        else {
		        	qualiteDeclarante.setAutreQualité(LigneParticipationDeclaranteBD.get(i).getQualitéEntreprise());
		        }
	        LigneparticipationDeclarante.setQualiteEntreprise(qualiteDeclarante);
	        LigneparticipationDeclarante.setPourcentageDetentionCapital(LigneParticipationDeclaranteBD.get(i).getPourcentageDetentionCapital());
	        LigneparticipationDeclarante.setPourcentageDetentionDroitsVote(LigneParticipationDeclaranteBD.get(i).getPourcentageDetentionDroitsVote());
	        
	        ListeDeclarante.add(LigneparticipationDeclarante);
	        }
	        liensCapital.setParticipationDeclarante(ListeDeclarante);
	        ModificationLiensCapitalAuCoursExerciceBD ModificationLiensCapitalAuCoursExerciceBD=InformationsEntrepriseDeclaranteBD.getModificationLiensCapitalAuCoursExercice();
	        ModificationLiensCapitalAuCoursExercice ModificationLiensCapitalAuCoursExercice=new ModificationLiensCapitalAuCoursExercice();
	        ModificationLiensCapitalAuCoursExercice.setAffirmation(ModificationLiensCapitalAuCoursExerciceBD.getAffirmation());
	        ModificationLiensCapitalAuCoursExercice.setDescription(ModificationLiensCapitalAuCoursExerciceBD.getDescription());
	        liensCapital.setModificationLiensCapitalAuCoursExercice(ModificationLiensCapitalAuCoursExercice);
	        
	        infos.setLiensCapital(liensCapital);
	        prixTransfert.setInformationsEntrepriseDeclarante(infos);
             InformationsGroupeEntreprisesBD InformationsGroupeEntreprisesBD =DéclarationPrixDeTransfert.getInformationsGroupeEntreprises();
             InformationsMereEntiteUltimeBD InformationsMereEntiteUltimeBD=InformationsGroupeEntreprisesBD.getInformationsMereEntiteUltime();
	        InformationsGroupeEntreprises InformationsGroupeEntreprises =new InformationsGroupeEntreprises();
	        InformationsEntiteMereUltime InformationsEntiteMereUltime =new InformationsEntiteMereUltime();
	        IdentifiantEntreprise IdentifiantEntreprise =new IdentifiantEntreprise();
	        if(InformationsMereEntiteUltimeBD.getMatriculeFiscal()!=null && !InformationsMereEntiteUltimeBD.getMatriculeFiscal().isEmpty()) {
	        	IdentifiantEntreprise.setMatriculeFiscal(InformationsMereEntiteUltimeBD.getMatriculeFiscal());
	        	}else {
	        		IdentifiantEntreprise.setAutreIdentifiant(new AutreIdentifiant());
	        		IdentifiantEntreprise.getAutreIdentifiant().setEtatTerritoire(InformationsMereEntiteUltimeBD.getEtatTerritoire());;
	        		IdentifiantEntreprise.getAutreIdentifiant().setIdentifiant(InformationsMereEntiteUltimeBD.getIdentifiant());
	        	}
	        InformationsEntiteMereUltime.setIdentifiantEntreprise(IdentifiantEntreprise);
	        InformationsEntiteMereUltime.setAdresseSiegeSocial(InformationsMereEntiteUltimeBD.getAdresseSiegeSocial());
	        InformationsEntiteMereUltime.setRaisonSociale(InformationsMereEntiteUltimeBD.getRaisonSociale());
	        InformationsGroupeEntreprises.setInformationsEntiteMereUltime(InformationsEntiteMereUltime);
	        InformationsGroupeEntreprises.setDescriptionPrincipalesActivites(InformationsGroupeEntreprisesBD.getDescriptionPrincipalesActivites());
	       InformationsGroupeEntreprises.setDescriptionGeneralePolitiquePrixTransfert(InformationsGroupeEntreprisesBD.getDescriptionGeneralePolitiquePrixTransfert());
	       
	       
	       
	       
	       
	       
	       List<LigneActifInCorporelBD> LigneActifIncorporelBD=InformationsGroupeEntreprisesBD.getLigneActifInCorporel();
	        List<LigneActifIncorporel> ListeIncorporel =new ArrayList<>();
	        for (int i=0; i <LigneActifIncorporelBD.size();i++) {
	        	LigneActifIncorporel LigneActifIncorporel = new LigneActifIncorporel();
		        IdentifiantEntreprise identifiantIncorporel = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteIncorporel = new QualiteEntreprise();
		        if(LigneActifIncorporelBD.get(i).getMatriculeFiscal()!=null && !LigneActifIncorporelBD.get(i).getMatriculeFiscal().isEmpty()) {
			        identifiantIncorporel.setMatriculeFiscal(LigneActifIncorporelBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantIncorporel.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantIncorporel.getAutreIdentifiant().setEtatTerritoire(LigneActifIncorporelBD.get(i).getEtatTerritoire());
			        identifiantIncorporel.getAutreIdentifiant().setIdentifiant(LigneActifIncorporelBD.get(i).getIdentifiant());
			        }
	        
		        LigneActifIncorporel.setIdentifiantEntreprise(identifiantIncorporel);
		        LigneActifIncorporel.setRaisonSociale(LigneActifIncorporelBD.get(i).getRaisonSociale());
	        
		        if (LigneActifIncorporelBD.get(i).getQualite()!=null &&  !LigneActifIncorporelBD.get(i).getQualite().isEmpty()) {
		        	qualiteIncorporel.setQualite(Integer.parseInt(LigneActifIncorporelBD.get(i).getQualite()));
		        	
		        }
		        else {
		        	qualiteIncorporel.setAutreQualité(LigneActifIncorporelBD.get(i).getAutrequalité());
		        }
	        LigneActifIncorporel.setQualiteEntreprise(qualiteIncorporel);
	        
	        LigneActifIncorporel.setActifIncorporel(new ActifIncorporel());
	        LigneActifIncorporel.getActifIncorporel().setNatureActifIncorporel(LigneActifIncorporelBD.get(i).getNatureActifIncorporel());
	        LigneActifIncorporel.getActifIncorporel().setAutreNatureActifIncorporel(LigneActifIncorporelBD.get(i).getAutreNatureActifIncorporel());
	        LigneActifIncorporel.setOnereuxGratuit(LigneActifIncorporelBD.get(i).getOnreuxGratuit());
	        LigneActifIncorporel.setNatureRelationEntreprise(new NatureRelationEntreprise());
	        LigneActifIncorporel.getNatureRelationEntreprise().setAutreNatureRelation(LigneActifIncorporelBD.get(i).getAutreNatureRelation());
	        LigneActifIncorporel.getNatureRelationEntreprise().setNatureRelation(LigneActifIncorporelBD.get(i).getNatureRelation());
	        ListeIncorporel.add(LigneActifIncorporel);
	        }
	       
	       InformationsGroupeEntreprises.setListeActifsIncorporels(ListeIncorporel);
	       
	       List<LigneActifCorporelBD> LigneActifcorporelBD=InformationsGroupeEntreprisesBD.getLigneActifCorporel();
	        List<LigneActifCorporel> Listecorporel =new ArrayList<>();
	        for (int i=0; i <LigneActifcorporelBD.size();i++) {
	        	LigneActifCorporel LigneActifCorporel = new LigneActifCorporel();
		        IdentifiantEntreprise identifiantcorporel = new IdentifiantEntreprise();
		        QualiteEntreprise qualitecorporel = new QualiteEntreprise();
		        if(LigneActifcorporelBD.get(i).getMatriculeFiscal()!=null) {
			        identifiantcorporel.setMatriculeFiscal(LigneActifcorporelBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantcorporel.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantcorporel.getAutreIdentifiant().setEtatTerritoire(LigneActifcorporelBD.get(i).getEtatTerritoire());
			        identifiantcorporel.getAutreIdentifiant().setIdentifiant(LigneActifcorporelBD.get(i).getIdentifiant());
			        }
	        
		        LigneActifCorporel.setIdentifiantEntreprise(identifiantcorporel);
		        LigneActifCorporel.setRaisonSociale(LigneActifcorporelBD.get(i).getRaisonSociale());
	        
		        if (LigneActifcorporelBD.get(i).getQualite()!=null &&  !LigneActifcorporelBD.get(i).getQualite().isEmpty()) {
		        	qualitecorporel.setQualite(Integer.parseInt(LigneActifcorporelBD.get(i).getQualite()));
		        	
		        }
		        else {
		        	qualitecorporel.setAutreQualité(LigneActifcorporelBD.get(i).getAutrequalité());
		        }
	        LigneActifCorporel.setQualiteEntreprise(qualitecorporel);
	        
	        LigneActifCorporel.setActifcorporel(new Actifcorporel());
	        LigneActifCorporel.getActifcorporel().setNatureActifcorporel(LigneActifcorporelBD.get(i).getNatureActifcorporel());
	        LigneActifCorporel.getActifcorporel().setAutreNatureActifcorporel(LigneActifcorporelBD.get(i).getAutreNatureActifcorporel());
	        
	        LigneActifCorporel.setNatureRelationEntreprise(new NatureRelationEntreprise());
	        LigneActifCorporel.getNatureRelationEntreprise().setAutreNatureRelation(LigneActifcorporelBD.get(i).getAutreNatureRelation());
	        LigneActifCorporel.getNatureRelationEntreprise().setNatureRelation(LigneActifcorporelBD.get(i).getNatureRelation());
	        Listecorporel.add(LigneActifCorporel);
	        }
	       
	       InformationsGroupeEntreprises.setListeActifsCorporels(Listecorporel);;
	       prixTransfert.setInformationsGroupeEntreprises(InformationsGroupeEntreprises);
	       
	        
	       InformationsOperationsBD InformationsOperationsBD=DéclarationPrixDeTransfert.getInformationsOperations();
	       InformationsOperations InformationsOperations=new InformationsOperations();
	       MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfertBD=InformationsOperationsBD.getMontantTransactionsMethodeDeterminationPrixTransfert();
	       MontantTransactionsMethodeDeterminationPrixTransfert MontantTransactionsMethodeDeterminationPrixTransfert=new MontantTransactionsMethodeDeterminationPrixTransfert();
	       InformationsValeursExploitationBD InformationsValeursExploitationBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsValeursExploitation();
	       InformationsValeursExploitation  InformationsValeursExploitation =new InformationsValeursExploitation() ;
	       InformationsRemunerationsBiensCorporelsIncorporels InformationsRemunerationsBiensCorporelsIncorporels =new InformationsRemunerationsBiensCorporelsIncorporels() ;
	       
	       List <LigneValeurExploitationBD> LigneValeurExploitationBD =InformationsValeursExploitationBD.getLigneValeurExploitation();
	       List<LigneValeurExploitation> ListeValeur =new ArrayList<>();
	       for (int j=0;j<LigneValeurExploitationBD.size();j++) {
	    	   LigneValeurExploitation LigneValeurExploitation=new LigneValeurExploitation();
	    	   
		        IdentifiantEntreprise identifiantValeur = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteValeur = new QualiteEntreprise();
		        if(LigneValeurExploitationBD.get(j).getMatriculeFiscal()!=null && !LigneValeurExploitationBD.get(j).getMatriculeFiscal().isEmpty()) {
			        identifiantValeur.setMatriculeFiscal(LigneValeurExploitationBD.get(j).getMatriculeFiscal());
			        }
			        else  {identifiantValeur.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantValeur.getAutreIdentifiant().setEtatTerritoire(LigneValeurExploitationBD.get(j).getEtatTerritoire());
			        identifiantValeur.getAutreIdentifiant().setIdentifiant(LigneValeurExploitationBD.get(j).getIdentifiant());
			        }
		        LigneValeurExploitation.setIdentifiantEntreprise(identifiantValeur);
		        if (LigneValeurExploitationBD.get(j).getQualite()!=null &&  !LigneValeurExploitationBD.get(j).getQualite().isEmpty()) {
		        	qualiteValeur.setQualite(Integer.parseInt(LigneValeurExploitationBD.get(j).getQualite()));
		        	
		        }
		        else {
		        	qualiteValeur.setAutreQualité(LigneValeurExploitationBD.get(j).getAutreQualite());
		        }
		        LigneValeurExploitation.setQualiteEntreprise(qualiteValeur);
		        LigneValeurExploitation.setNatureOperationValeurExploitation(new NatureOperationValeurExploitation());
		        LigneValeurExploitation.getNatureOperationValeurExploitation().setAutreNatureOperation(LigneValeurExploitationBD.get(j).getAutreNatureOperation());
		        LigneValeurExploitation.getNatureOperationValeurExploitation().setNatureOperation(LigneValeurExploitationBD.get(j).getNatureOperation());
		        LigneValeurExploitation.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneValeurExploitation.getNatureRelationEntreprise().setAutreNatureRelation(LigneValeurExploitationBD.get(j).getAutreNatureRelation());
		        LigneValeurExploitation.getNatureRelationEntreprise().setNatureRelation(LigneValeurExploitationBD.get(j).getNatureRelation());
		        LigneValeurExploitation.setAchatsDepenses(LigneValeurExploitationBD.get(j).getAchatsDepenses());
		        LigneValeurExploitation.setRaisonSociale(LigneValeurExploitationBD.get(j).getRaisonSociale());
		        LigneValeurExploitation.setVentesRevenus(LigneValeurExploitationBD.get(j).getVentesRevenus());
		        LigneValeurExploitation.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneValeurExploitation.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getAutreMethodeDeterminationPrixTransfert());
		        LigneValeurExploitation.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getMethodeDeterminationPrixTransfert());
		        LigneValeurExploitation.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneValeurExploitation.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneValeurExploitation.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getMethodeDeterminationPrixTransfert());
		        
		        ListeValeur.add(LigneValeurExploitation);
	       }
	       
	       InformationsValeursExploitation.setValeursExploitation(ListeValeur);
	       InformationsValeursExploitation.setTotalAchatsDepensesValeursExploitation(InformationsValeursExploitationBD.getTotalAchatsDepensesValeursExploitation());
	       InformationsValeursExploitation.setTotalVentesRevenusValeursExploitation(InformationsValeursExploitationBD.getTotalVentesRevenusValeursExploitation());
	       
	       
	       
	       
	       
	       InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporelsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsRemunerationsBiensCorporelsIncorporels();
	      
	       List<LigneRemunerationBiensBD> LigneRemunerationBiensBD=InformationsRemunerationsBiensCorporelsIncorporelsBD.getLigneRemunerationBiens();
	       List<LigneRemunerationsBiens> ListeRemunerations =new ArrayList<>();
	       
	       
	       for(int k=0 ;k<LigneRemunerationBiensBD.size();k++) {
	    	   LigneRemunerationsBiens LigneRemunerationBiens=new LigneRemunerationsBiens();
	    	   IdentifiantEntreprise identifiantRemunerations = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteRemunerations = new QualiteEntreprise();
		        if(LigneRemunerationBiensBD.get(k).getMatriculeFiscal()!=null && !LigneRemunerationBiensBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantRemunerations.setMatriculeFiscal(LigneRemunerationBiensBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantRemunerations.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantRemunerations.getAutreIdentifiant().setEtatTerritoire(LigneRemunerationBiensBD.get(k).getEtatTerritoire());
			        identifiantRemunerations.getAutreIdentifiant().setIdentifiant(LigneRemunerationBiensBD.get(k).getIdentifiant());
			        }
		        LigneRemunerationBiens.setIdentifiantEntreprise(identifiantRemunerations);
		        if (LigneRemunerationBiensBD.get(k).getQualite()!=null &&  !LigneRemunerationBiensBD.get(k).getQualite().isEmpty()) {
		        	qualiteRemunerations.setQualite(Integer.parseInt(LigneRemunerationBiensBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteRemunerations.setAutreQualité(LigneRemunerationBiensBD.get(k).getAutreQualite());
		        }
		        LigneRemunerationBiens.setQualiteEntreprise(qualiteRemunerations);
		        LigneRemunerationBiens.setNatureOperationRemunerationBiens(new NatureOperationRemunerationBiens());
		        LigneRemunerationBiens.getNatureOperationRemunerationBiens().setAutreNatureOperation(LigneRemunerationBiensBD.get(k).getAutreNatureOperation());
		        LigneRemunerationBiens.getNatureOperationRemunerationBiens().setNatureOperation(LigneRemunerationBiensBD.get(k).getNatureOperation());
		        LigneRemunerationBiens.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneRemunerationBiens.getNatureRelationEntreprise().setAutreNatureRelation(LigneRemunerationBiensBD.get(k).getAutreNatureRelation());
		        LigneRemunerationBiens.getNatureRelationEntreprise().setNatureRelation(LigneRemunerationBiensBD.get(k).getNatureRelation());
		        LigneRemunerationBiens.setAchatsDepenses(LigneRemunerationBiensBD.get(k).getAchatsDepenses());
		        LigneRemunerationBiens.setRaisonSociale(LigneRemunerationBiensBD.get(k).getRaisonSociale());
		        LigneRemunerationBiens.setVentesRevenus(LigneRemunerationBiensBD.get(k).getVentesRevenus());
		        LigneRemunerationBiens.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneRemunerationBiens.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        LigneRemunerationBiens.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getMethodeDeterminationPrixTransfert());
		        LigneRemunerationBiens.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneRemunerationBiens.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneRemunerationBiens.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getMethodeDeterminationPrixTransfert());
		        
		        ListeRemunerations.add(LigneRemunerationBiens);
	       
	       }
	       
	       InformationsRemunerationsBiensCorporelsIncorporels.setRemunerationsBiensCorporelsIncorporels(ListeRemunerations);
	       InformationsRemunerationsBiensCorporelsIncorporels.setTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporelsBD.getTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels());
	       InformationsRemunerationsBiensCorporelsIncorporels.setTotalVentesRevenusRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporelsBD.getTotalVentesRevenusRemunerationsBiensCorporelsIncorporels());
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporels);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsValeursExploitation(InformationsValeursExploitation);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       InformationsServices InformationsServices =new InformationsServices();
	       InformationsServicesBD InformationsServicesBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsServices();
	       InformationsServices.setTotalAchatsDepensesServices(InformationsServicesBD.getTotalAchatsDepensesServices());
	       InformationsServices.setTotalVentesRevenusServices(InformationsServicesBD.getTotalAchatsDepensesServices());
	       List<LigneServiceBD> LigneServiceBD=InformationsServicesBD.getLigneService();
	       List<LigneService> ListeService =new ArrayList<>();
	       for(int k=0;k<LigneServiceBD.size();k++) {
	    	   LigneService LigneService =new LigneService();
	    	   IdentifiantEntreprise identifiantService = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteService = new QualiteEntreprise();
		        if(LigneServiceBD.get(k).getMatriculeFiscal()!=null && !LigneServiceBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantService.setMatriculeFiscal(LigneServiceBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantService.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantService.getAutreIdentifiant().setEtatTerritoire(LigneServiceBD.get(k).getEtatTerritoire());
			        identifiantService.getAutreIdentifiant().setIdentifiant(LigneServiceBD.get(k).getIdentifiant());
			        }
		        LigneService.setIdentifiantEntreprise(identifiantService);
		        if (LigneServiceBD.get(k).getQualite()!=null &&  !LigneServiceBD.get(k).getQualite().isEmpty()) {
		        	qualiteService.setQualite(Integer.parseInt(LigneServiceBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteService.setAutreQualité(LigneServiceBD.get(k).getAutreQualite());
		        }
		        LigneService.setQualiteEntreprise(qualiteService);
		        LigneService.setNatureOperationService(new NatureOperationService());
		        LigneService.getNatureOperationService().setAutreNatureOperation(LigneServiceBD.get(k).getAutreNatureOperation());
		        LigneService.getNatureOperationService().setNatureOperation(LigneServiceBD.get(k).getNatureOperation());
		        LigneService.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneService.getNatureRelationEntreprise().setAutreNatureRelation(LigneServiceBD.get(k).getAutreNatureRelation());
		        LigneService.getNatureRelationEntreprise().setNatureRelation(LigneServiceBD.get(k).getNatureRelation());
		        LigneService.setAchatsDepenses(LigneServiceBD.get(k).getAchatsDepenses());
		        LigneService.setRaisonSociale(LigneServiceBD.get(k).getRaisonSociale());
		        LigneService.setVentesRevenus(LigneServiceBD.get(k).getVentesRevenus());
		        LigneService.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneService.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        LigneService.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getMethodeDeterminationPrixTransfert());
		        LigneService.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneService.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneService.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getMethodeDeterminationPrixTransfert());
		        
	    	   ListeService.add(LigneService);
	       }
	       
	       InformationsServices.setServices(ListeService);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsServices(InformationsServices);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       InformationsOperationsFinancieres InformationsOperationsFinancieres=new InformationsOperationsFinancieres();
	       InformationsOperationsFinancieresBD InformationsOperationsFinancieresBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsOperationsFinancieres();
	       InformationsOperationsFinancieres.setTotalAchatsDepensesOperationsFinancieres(InformationsOperationsFinancieresBD.getTotalAchatsDepensesOperationsFinancieres());
	       InformationsOperationsFinancieres.setTotalVentesRevenusOperationsFinancieres(InformationsOperationsFinancieresBD.getTotalVentesRevenusOperationsFinancieres());
	       List<LigneOperationFinanciereBD> LigneOperationFinanciereBD = InformationsOperationsFinancieresBD.getLigneOperationFinanciere();
	       List<LigneOperationFinanciere> ListeOperationF =new ArrayList<>();
	       
	        
	       for(int k=0;k<LigneOperationFinanciereBD.size();k++) {
	    	   LigneOperationFinanciere LigneOperationFinanciere =new LigneOperationFinanciere();
	    	   IdentifiantEntreprise identifiantOperationF = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteOperationF = new QualiteEntreprise();
		        if(LigneOperationFinanciereBD.get(k).getMatriculeFiscal()!=null && !LigneOperationFinanciereBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantOperationF.setMatriculeFiscal(LigneOperationFinanciereBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantOperationF.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantOperationF.getAutreIdentifiant().setEtatTerritoire(LigneOperationFinanciereBD.get(k).getEtatTerritoire());
			        identifiantOperationF.getAutreIdentifiant().setIdentifiant(LigneOperationFinanciereBD.get(k).getIdentifiant());
			        }
		        LigneOperationFinanciere.setIdentifiantEntreprise(identifiantOperationF);
		        if (LigneOperationFinanciereBD.get(k).getQualite()!=null &&  !LigneOperationFinanciereBD.get(k).getQualite().isEmpty()) {
		        	qualiteOperationF.setQualite(Integer.parseInt(LigneOperationFinanciereBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteOperationF.setAutreQualité(LigneOperationFinanciereBD.get(k).getAutreQualite());
		        }
		        LigneOperationFinanciere.setQualiteEntreprise(qualiteOperationF);
		        LigneOperationFinanciere.setNatureOperationFinanciere(new NatureOperationFinanciere());
		        LigneOperationFinanciere.getNatureOperationFinanciere().setAutreNatureOperation(LigneOperationFinanciereBD.get(k).getAutreNatureOperation());
		        LigneOperationFinanciere.getNatureOperationFinanciere().setNatureOperation(LigneOperationFinanciereBD.get(k).getNatureOperation());
		        LigneOperationFinanciere.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneOperationFinanciere.getNatureRelationEntreprise().setAutreNatureRelation(LigneOperationFinanciereBD.get(k).getAutreNatureRelation());
		        LigneOperationFinanciere.getNatureRelationEntreprise().setNatureRelation(LigneOperationFinanciereBD.get(k).getNatureRelation());
		        LigneOperationFinanciere.setAchatsDepenses(LigneOperationFinanciereBD.get(k).getAchatsDepenses());
		        LigneOperationFinanciere.setRaisonSociale(LigneOperationFinanciereBD.get(k).getRaisonSociale());
		        LigneOperationFinanciere.setVentesRevenus(LigneOperationFinanciereBD.get(k).getVentesRevenus());
		        LigneOperationFinanciere.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneOperationFinanciere.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        LigneOperationFinanciere.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getMethodeDeterminationPrixTransfert());
		        LigneOperationFinanciere.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneOperationFinanciere.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneOperationFinanciere.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getMethodeDeterminationPrixTransfert());
		        
	    	   ListeOperationF.add(LigneOperationFinanciere);}
	       
	       InformationsOperationsFinancieres.setOperationsFinancieres(ListeOperationF);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsOperationsFinancieres(InformationsOperationsFinancieres);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       
	       
	       
	       InformationsCessionsAcquisitionsActifs InformationsCessionsAcquisitionsActifs=new InformationsCessionsAcquisitionsActifs();
	       InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsCessionsAcquisitionsActifs();
	       InformationsCessionsAcquisitionsActifs.setTotalAchatsDepensesCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifsBD.getTotalAchatsDepensesCessionsAcquisitionsActifs());
	       InformationsCessionsAcquisitionsActifs.setTotalVentesRevenusCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifsBD.getTotalVentesRevenusCessionsAcquisitionsActifs()); 
	       List<LigneCessionAcquisitionActifBD> LigneCessionAcquisitionActifBD =InformationsCessionsAcquisitionsActifsBD.getLigneCessionAcquisitionActif();
	       List<LigneCessionAcquisitionActif> ListeCession =new ArrayList<>();
	       
	       for(int k=0;k<LigneCessionAcquisitionActifBD.size();k++) {
	    	   LigneCessionAcquisitionActif LigneCessionAcquisitionActif =new LigneCessionAcquisitionActif();
	    	   IdentifiantEntreprise identifiantCession = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteCession= new QualiteEntreprise();
		        if(LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal()!=null && !LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantCession.setMatriculeFiscal(LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantCession.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantCession.getAutreIdentifiant().setEtatTerritoire(LigneCessionAcquisitionActifBD.get(k).getEtatTerritoire());
			        identifiantCession.getAutreIdentifiant().setIdentifiant(LigneCessionAcquisitionActifBD.get(k).getIdentifiant());
			        }
		        LigneCessionAcquisitionActif.setIdentifiantEntreprise(identifiantCession);
		        if (LigneCessionAcquisitionActifBD.get(k).getQualite()!=null &&  !LigneCessionAcquisitionActifBD.get(k).getQualite().isEmpty()) {
		        	qualiteCession.setQualite(Integer.parseInt(LigneCessionAcquisitionActifBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteCession.setAutreQualité(LigneCessionAcquisitionActifBD.get(k).getAutreQualite());
		        }
		        LigneCessionAcquisitionActif.setQualiteEntreprise(qualiteCession);
		        LigneCessionAcquisitionActif.setNatureOperationCessionAcquisitionActif (new NatureOperationCessionAcquisitionActif ());
		        LigneCessionAcquisitionActif.getNatureOperationCessionAcquisitionActif ().setAutreNatureOperation(LigneCessionAcquisitionActifBD.get(k).getAutreNatureOperation());
		        LigneCessionAcquisitionActif.getNatureOperationCessionAcquisitionActif ().setNatureOperation(LigneCessionAcquisitionActifBD.get(k).getNatureOperation());
		        LigneCessionAcquisitionActif.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneCessionAcquisitionActif.getNatureRelationEntreprise().setAutreNatureRelation(LigneCessionAcquisitionActifBD.get(k).getAutreNatureRelation());
		        LigneCessionAcquisitionActif.getNatureRelationEntreprise().setNatureRelation(LigneOperationFinanciereBD.get(k).getNatureRelation());
		        LigneCessionAcquisitionActif.setAchatsDepenses(LigneCessionAcquisitionActifBD.get(k).getAchatsDepenses());
		        LigneCessionAcquisitionActif.setRaisonSociale(LigneCessionAcquisitionActifBD.get(k).getRaisonSociale());
		        LigneCessionAcquisitionActif.setVentesRevenus(LigneCessionAcquisitionActifBD.get(k).getVentesRevenus());
		        LigneCessionAcquisitionActif.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneCessionAcquisitionActif.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        LigneCessionAcquisitionActif.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getMethodeDeterminationPrixTransfert());
		        LigneCessionAcquisitionActif.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneCessionAcquisitionActif.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneCessionAcquisitionActif.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getMethodeDeterminationPrixTransfert());
		        
	    	   ListeCession.add(LigneCessionAcquisitionActif);}
	       
	       InformationsCessionsAcquisitionsActifs.setCessionsAcquisitionsActifs(ListeCession);
	       
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifs);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       
	       
	       InformationsAutresOperations InformationsAutresOperations=new InformationsAutresOperations();
	       InformationsAutresOperationsBD InformationsAutresOperationsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsAutresOperations();
	       InformationsAutresOperations.setTotalAchatsDepensesAutresOperations(InformationsAutresOperationsBD.getTotalAchatsDepensesAutresOperations());
	       InformationsAutresOperations.setTotalVentesRevenusAutresOperations(InformationsAutresOperationsBD.getTotalVentesRevenusAutresOperations()); 
	       List<LigneAutreOperationBD> LigneAutreOperationBD =InformationsAutresOperationsBD.getLigneAutreOperation();
	       List<LigneAutreOperation> ListeAutreOperation =new ArrayList<>();
	       
	       for(int k=0;k<LigneAutreOperationBD.size();k++) {
	    	   LigneAutreOperation LigneAutreOperation =new LigneAutreOperation();
	    	   IdentifiantEntreprise identifiantAutreOperation = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteAutreOperation= new QualiteEntreprise();
		        if(LigneAutreOperationBD.get(k).getMatriculeFiscal()!=null && !LigneAutreOperationBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantAutreOperation.setMatriculeFiscal(LigneAutreOperationBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantAutreOperation.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantAutreOperation.getAutreIdentifiant().setEtatTerritoire(LigneAutreOperationBD.get(k).getEtatTerritoire());
			        identifiantAutreOperation.getAutreIdentifiant().setIdentifiant(LigneAutreOperationBD.get(k).getIdentifiant());
			        }
		        LigneAutreOperation.setIdentifiantEntreprise(identifiantAutreOperation);
		        if (LigneAutreOperationBD.get(k).getQualite()!=null &&  !LigneAutreOperationBD.get(k).getQualite().isEmpty()) {
		        	qualiteAutreOperation.setQualite(Integer.parseInt(LigneAutreOperationBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteAutreOperation.setAutreQualité(LigneAutreOperationBD.get(k).getAutreQualite());
		        }
		        LigneAutreOperation.setQualiteEntreprise(qualiteAutreOperation);
		        LigneAutreOperation.setNatureAutreOperation (new NatureAutreOperation ());
		        LigneAutreOperation.getNatureAutreOperation ().setAutreNatureOperation(LigneAutreOperationBD.get(k).getAutreNatureOperation());
		        LigneAutreOperation.getNatureAutreOperation().setNatureOperation(LigneAutreOperationBD.get(k).getNatureOperation());
		        LigneAutreOperation.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneAutreOperation.getNatureRelationEntreprise().setAutreNatureRelation(LigneAutreOperationBD.get(k).getAutreNatureRelation());
		        LigneAutreOperation.getNatureRelationEntreprise().setNatureRelation(LigneAutreOperationBD.get(k).getNatureRelation());
		        LigneAutreOperation.setAchatsDepenses(LigneAutreOperationBD.get(k).getAchatsDepenses());
		        LigneAutreOperation.setRaisonSociale(LigneAutreOperationBD.get(k).getRaisonSociale());
		        LigneAutreOperation.setVentesRevenus(LigneAutreOperationBD.get(k).getVentesRevenus());
		        LigneAutreOperation.setMethodePrixTransfert(new MethodePrixTransfert());
		        LigneAutreOperation.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        LigneAutreOperation.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getMethodeDeterminationPrixTransfert());
		        LigneAutreOperation.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        LigneAutreOperation.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        LigneAutreOperation.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getMethodeDeterminationPrixTransfert());
		        
	    	   ListeAutreOperation.add(LigneAutreOperation);}
	       
	       InformationsAutresOperations.setAutresOperations(ListeAutreOperation);
	       
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsAutresOperations(InformationsAutresOperations);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       InformationsPretsEmprunts InformationsPretsEmprunts =new InformationsPretsEmprunts ();
	       InformationsPretsEmpruntsBD InformationsPretsEmpruntsBD =InformationsOperationsBD.getInformationsPretsEmprunts();
	       List<LignePretAccordeBD> LignePretAccordeBD = InformationsPretsEmpruntsBD.getLignePretAccorde();
	       List<LignePretAccorde> ListePretAccorde =new ArrayList<>();
	       
	       for(int k=0;k<LigneAutreOperationBD.size();k++) {
	    	   LignePretAccorde LignePretAccorde =new LignePretAccorde();
	    	   IdentifiantEntreprise identifiantPretAccorde = new IdentifiantEntreprise();
		       QualiteEntreprise qualitePretAccorde= new QualiteEntreprise();
		        if(LignePretAccordeBD.get(k).getMatriculeFiscal()!=null && !LignePretAccordeBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantPretAccorde.setMatriculeFiscal(LignePretAccordeBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantPretAccorde.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantPretAccorde.getAutreIdentifiant().setEtatTerritoire(LignePretAccordeBD.get(k).getEtatTerritoire());
			        identifiantPretAccorde.getAutreIdentifiant().setIdentifiant(LignePretAccordeBD.get(k).getIdentifiant());
			        }
		        LignePretAccorde.setIdentifiantEntreprise(identifiantPretAccorde);
		        if (LignePretAccordeBD.get(k).getQualite()!=null &&  !LignePretAccordeBD.get(k).getQualite().isEmpty()) {
		        	qualitePretAccorde.setQualite(Integer.parseInt(LignePretAccordeBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualitePretAccorde.setAutreQualité(LignePretAccordeBD.get(k).getAutreQualité());
		        }
	            LignePretAccorde.setQualiteEntreprise(qualitePretAccorde);
	            LignePretAccorde.setDevise(LignePretAccordeBD.get(k).getDevise());
	            LignePretAccorde.setMouvementsAugmentations(LignePretAccordeBD.get(k).getMouvementsAugmentations());
	            LignePretAccorde.setMouvementsDiminutions(LignePretAccordeBD.get(k).getMouvementsDiminutions());
	            LignePretAccorde.setNatureRelationEntreprise(new NatureRelationEntreprise());
	            LignePretAccorde.getNatureRelationEntreprise().setAutreNatureRelation(LignePretAccordeBD.get(k).getAutreNatureRelation());
	            LignePretAccorde.getNatureRelationEntreprise().setNatureRelation(LignePretAccordeBD.get(k).getNatureRelation());
	            LignePretAccorde.setPretsInterets(LignePretAccordeBD.get(k).getPretsInterets());
	            LignePretAccorde.setRaisonSociale(LignePretAccordeBD.get(k).getRaisonSociale());
	            LignePretAccorde.setSoldeCloture(LignePretAccordeBD.get(k).getSoldeCloture());
	            LignePretAccorde.setSoldeOuverture(LignePretAccordeBD.get(k).getSoldeOuverture());
	            LignePretAccorde.setTauxInteret(LignePretAccordeBD.get(k).getTauxInterets());
	       
	          ListePretAccorde.add(LignePretAccorde);}
	       
	       InformationsPretsEmprunts.setPretsAccordes(ListePretAccorde);
	       InformationsOperations.setInformationsPretsEmprunts(InformationsPretsEmprunts);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       List<LigneEmpruntContracteBD> LigneEmpruntContracteBD = InformationsPretsEmpruntsBD.getLigneEmpruntContracte();
	       List<LigneEmpruntContracte> ListeEmpruntContracte =new ArrayList<>();
	       
	       for(int k=0;k<LigneEmpruntContracteBD.size();k++) {
	    	   LigneEmpruntContracte LigneEmpruntContracte =new LigneEmpruntContracte();
	    	   IdentifiantEntreprise identifiantEmpruntContracte = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteEmpruntContracte= new QualiteEntreprise();
		        if(LigneEmpruntContracteBD.get(k).getMatriculeFiscal()!=null && !LigneEmpruntContracteBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantEmpruntContracte.setMatriculeFiscal(LigneEmpruntContracteBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantEmpruntContracte.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantEmpruntContracte.getAutreIdentifiant().setEtatTerritoire(LigneEmpruntContracteBD.get(k).getEtatTerritoire());
			        identifiantEmpruntContracte.getAutreIdentifiant().setIdentifiant(LigneEmpruntContracteBD.get(k).getIdentifiant());
			        }
		        LigneEmpruntContracte.setIdentifiantEntreprise(identifiantEmpruntContracte);
		        if (LigneEmpruntContracteBD.get(k).getQualite()!=null &&  !LigneEmpruntContracteBD.get(k).getQualite().isEmpty()) {
		        	qualiteEmpruntContracte.setQualite(Integer.parseInt(LigneEmpruntContracteBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteEmpruntContracte.setAutreQualité(LigneEmpruntContracteBD.get(k).getAutreQualité());
		        }
		        LigneEmpruntContracte.setQualiteEntreprise(qualiteEmpruntContracte);
		        LigneEmpruntContracte.setDevise(LigneEmpruntContracteBD.get(k).getDevise());
		        LigneEmpruntContracte.setMouvementsAugmentations(LigneEmpruntContracteBD.get(k).getMouvementsAugmentations());
		        LigneEmpruntContracte.setMouvementsDiminutions(LigneEmpruntContracteBD.get(k).getMouvementsDiminutions());
		        LigneEmpruntContracte.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneEmpruntContracte.getNatureRelationEntreprise().setAutreNatureRelation(LigneEmpruntContracteBD.get(k).getAutreNatureRelation());
		        LigneEmpruntContracte.getNatureRelationEntreprise().setNatureRelation(LigneEmpruntContracteBD.get(k).getNatureRelation());
		        
		        LigneEmpruntContracte.setRaisonSociale(LigneEmpruntContracteBD.get(k).getRaisonSociale());
		        LigneEmpruntContracte.setSoldeCloture(LigneEmpruntContracteBD.get(k).getSoldeCloture());
		        LigneEmpruntContracte.setSoldeOuverture(LigneEmpruntContracteBD.get(k).getSoldeOuverture());
		        LigneEmpruntContracte.setTauxInteret(LigneEmpruntContracteBD.get(k).getTauxInterets());
	       
	          ListeEmpruntContracte.add(LigneEmpruntContracte);}
	       
	       InformationsPretsEmprunts.setEmpruntsContractes(ListeEmpruntContracte);
	       InformationsOperations.setInformationsPretsEmprunts(InformationsPretsEmprunts);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire OperationsSansContrepartieOuAvecContrepartieNonMonetaire=new OperationsSansContrepartieOuAvecContrepartieNonMonetaire();
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD =InformationsOperationsBD.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire();
	       InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartieBD=OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD.getInformationsSurBiensOuServicesSansContrePartie();
	       InformationsSurBiensOuServicesSansContrePartie InformationsSurBiensOuServicesSansContrePartie =new InformationsSurBiensOuServicesSansContrePartie();
	       InformationsSurBiensOuServicesSansContrePartie.setAffirmation(InformationsSurBiensOuServicesSansContrePartieBD.getAffirmation());
	       List<LigneBiensOuServicesSansContrePartieBD> LigneBiensOuServicesSansContrePartieBD=InformationsSurBiensOuServicesSansContrePartieBD.getLigneBiensOuServicesSansContrePartie();
	       List<LigneBiensOuServicesSansContrePartie> ListeBiensOuServices =new ArrayList<>();
	       
	       for(int k=0;k<LigneBiensOuServicesSansContrePartieBD.size();k++) {
	    	   LigneBiensOuServicesSansContrePartie LigneBiensOuServicesSansContrePartie =new LigneBiensOuServicesSansContrePartie();
	    	   IdentifiantEntreprise identifiantBiensOuServices = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteBiensOuServices = new QualiteEntreprise();
		        if(LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal()!=null && !LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantBiensOuServices .setMatriculeFiscal(LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantBiensOuServices.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantBiensOuServices.getAutreIdentifiant().setEtatTerritoire(LigneBiensOuServicesSansContrePartieBD.get(k).getEtatTerritoire());
			        identifiantBiensOuServices.getAutreIdentifiant().setIdentifiant(LigneBiensOuServicesSansContrePartieBD.get(k).getIdentifiant());
			        }
		        LigneBiensOuServicesSansContrePartie.setIdentifiantEntreprise(identifiantBiensOuServices );
		        if (LigneBiensOuServicesSansContrePartieBD.get(k).getQualite()!=null &&  !LigneBiensOuServicesSansContrePartieBD.get(k).getQualite().isEmpty()) {
		        	qualiteBiensOuServices.setQualite(Integer.parseInt(LigneBiensOuServicesSansContrePartieBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteBiensOuServices.setAutreQualité(LigneBiensOuServicesSansContrePartieBD.get(k).getAutreQualité());
		        }
		        
		        LigneBiensOuServicesSansContrePartie.setQualiteEntreprise(qualiteBiensOuServices);
		        
		        LigneBiensOuServicesSansContrePartie.setNatureBiensOuService(LigneBiensOuServicesSansContrePartieBD.get(k).getNatureBiensOuService());
		        LigneBiensOuServicesSansContrePartie.setNatureContrepartie(LigneBiensOuServicesSansContrePartieBD.get(k).getNatureContrepartie());
		        LigneBiensOuServicesSansContrePartie.setRaisonSociale(LigneBiensOuServicesSansContrePartieBD.get(k).getRaisonSociale());
		        ListeBiensOuServices.add(LigneBiensOuServicesSansContrePartie);}
	         
	       InformationsSurBiensOuServicesSansContrePartie.setBiensOuServicesSansContrePartie(ListeBiensOuServices);
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire.setInformationsSurBiensOuServicesSansContrePartie(InformationsSurBiensOuServicesSansContrePartie);
	       InformationsOperations.setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(OperationsSansContrepartieOuAvecContrepartieNonMonetaire);
	       prixTransfert.setInformationsOperations(InformationsOperations);
		        
	       InformationsSurContrepartieNonMonetairePourBiensOuServicesBD InformationsSurContrepartieNonMonetairePourBiensOuServicesBD=OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD.getInformationsSurContrepartieNonMonetairePourBiensOuServices();
	       InformationsSurContrepartieNonMonetairePourBiensOuServices InformationsSurContrepartieNonMonetairePourBiensOuServices =new InformationsSurContrepartieNonMonetairePourBiensOuServices();
	       InformationsSurContrepartieNonMonetairePourBiensOuServices.setAffirmation(InformationsSurContrepartieNonMonetairePourBiensOuServicesBD.getAffirmation());
	       List<LigneContrepartieNonMonetairePourBiensOuServicesBD> LigneContrepartieNonMonetairePourBiensOuServicesBD=InformationsSurContrepartieNonMonetairePourBiensOuServicesBD.getLigneContrepartieNonMonetairePourBiensOuServices();
	       List<LigneContrepartieNonMonetairePourBiensOuServices> ListeContrePartie =new ArrayList<>();
	       
	       for(int k=0;k<LigneContrepartieNonMonetairePourBiensOuServicesBD.size();k++) {
	    	   LigneContrepartieNonMonetairePourBiensOuServices LigneContrepartieNonMonetairePourBiensOuServices =new LigneContrepartieNonMonetairePourBiensOuServices();
	    	   IdentifiantEntreprise identifiantContrePartie = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteContrePartie = new QualiteEntreprise();
		        if(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal()!=null && !LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantContrePartie .setMatriculeFiscal(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantContrePartie.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantContrePartie.getAutreIdentifiant().setEtatTerritoire(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getEtatTerritoire());
			        identifiantContrePartie.getAutreIdentifiant().setIdentifiant(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getIdentifiant());
			        }
		        LigneContrepartieNonMonetairePourBiensOuServices.setIdentifiantEntreprise(identifiantContrePartie );
		        if (LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite()!=null &&  !LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite().isEmpty()) {
		        	qualiteContrePartie.setQualite(Integer.parseInt(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteContrePartie.setAutreQualité(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getAutreQualité());
		        }
		        
		        
		        
		        LigneContrepartieNonMonetairePourBiensOuServices.setQualiteEntreprise(qualiteContrePartie);
		        
		        LigneContrepartieNonMonetairePourBiensOuServices.setNatureBiensOuService(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getNatureBiensOuService());
		        LigneContrepartieNonMonetairePourBiensOuServices.setNatureContrepartie(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getNatureContrepartie());
		        LigneContrepartieNonMonetairePourBiensOuServices.setRaisonSociale(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getRaisonSociale());
		        ListeContrePartie.add(LigneContrepartieNonMonetairePourBiensOuServices);}
	         
	       InformationsSurContrepartieNonMonetairePourBiensOuServices.setContrepartieNonMonetairePourBiensOuServices(ListeContrePartie);
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire.setInformationsSurContrepartieNonMonetairePourBiensOuServices(InformationsSurContrepartieNonMonetairePourBiensOuServices);
	       InformationsOperations.setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(OperationsSansContrepartieOuAvecContrepartieNonMonetaire);
	       prixTransfert.setInformationsOperations(InformationsOperations);
		        
	       
	       
	       
	       
	       
	       InformationsOperationsAccordsPrealablesOuRescritsFiscaux InformationsOperationsAccordsPrealablesOuRescritsFiscaux =new InformationsOperationsAccordsPrealablesOuRescritsFiscaux();
	       InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD=InformationsOperationsBD.getInformationsOperationsAccordsPrealablesOuRescritsFiscaux();
	       InformationsOperationsAccordsPrealablesOuRescritsFiscaux.setAffirmation(InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD.getAffirmation());
	       List<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD> LigneOperationsAccordsPrealablesOuRescritsFiscauxBD=InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD.getLigneOperationsAccordsPrealablesOuRescritsFiscaux();
           List<LigneOperationsAccordsPrealablesOuRescritsFiscaux> ListeOperationsAccords =new ArrayList<>();
           
           for(int k=0;k<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.size();k++) {
        	   LigneOperationsAccordsPrealablesOuRescritsFiscaux LigneOperationsAccordsPrealablesOuRescritsFiscaux =new LigneOperationsAccordsPrealablesOuRescritsFiscaux();
	    	   IdentifiantEntreprise identifiantOperationsAccords = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteOperationsAccords= new QualiteEntreprise();
		        if(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal()!=null && !LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal().isEmpty()) {
		        	identifiantOperationsAccords.setMatriculeFiscal(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantOperationsAccords.setAutreIdentifiant(new AutreIdentifiant());
			        identifiantOperationsAccords.getAutreIdentifiant().setEtatTerritoire(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getEtatTerritoire());
			        identifiantOperationsAccords.getAutreIdentifiant().setIdentifiant(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getIdentifiant());
			        }
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setIdentifiantEntreprise(identifiantOperationsAccords );
		        
		        if (LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite()!=null &&  !LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite().isEmpty()) {
		        	qualiteOperationsAccords.setQualite(Integer.parseInt(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	 qualiteOperationsAccords.setAutreQualité(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getAutreQualité());
		        }
		        
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setQualiteEntreprise(qualiteOperationsAccords);
		        
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.getNatureRelationEntreprise().setAutreNatureRelation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getAutreNatureOperation());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.getNatureRelationEntreprise().setNatureRelation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureRelation());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setExerciceDebut(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getExerciceDebut());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setExerciceFin(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getExerciceFin());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setRaisonSociale(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getRaisonSociale());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setNatureOperation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureOperation());

	       
		        ListeOperationsAccords.add(LigneOperationsAccordsPrealablesOuRescritsFiscaux);}
           
              
           InformationsOperationsAccordsPrealablesOuRescritsFiscaux.setOperationsAccordsPrealablesOuRescritsFiscaux(ListeOperationsAccords);
           InformationsOperations.setInformationsOperationsAccordsPrealablesOuRescritsFiscaux(InformationsOperationsAccordsPrealablesOuRescritsFiscaux);
           prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
           AutresInformationsARenseignerSurDeclarationPrixTransfert AutresInformationsARenseignerSurDeclarationPrixTransfert=DéclarationPrixDeTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert();
           prixTransfert.setAutresInformationsARenseignerSurDeclarationPrixTransfert(AutresInformationsARenseignerSurDeclarationPrixTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert());
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	        return prixTransfert;
	    }
	}


