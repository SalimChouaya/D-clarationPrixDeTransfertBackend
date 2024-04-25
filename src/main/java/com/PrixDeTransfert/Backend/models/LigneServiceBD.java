package com.PrixDeTransfert.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class LigneServiceBD {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @Column
	    String NatureOperation;
		 @Column
		 String AutreNatureOperation;
		 @Column
		String AchatsDepenses ;
		 @Column
		String VentesRevenus ;
		 @Column
		String Identifiant ;
		 @Column
		 String EtatTerritoire;
		 @Column
		 String MatriculeFiscal;
		 
		 @Column
		String RaisonSociale ;
		 @Column
		String Qualite ;
		 @Column
		 String AutreQualite;
		 @Column
		String NatureRelation ;
		 @Column
			String AutreNatureRelation ;
		 @Column
		String MethodeDeterminationPrixTransfert  ;
		 @Column
			String AutreMethodeDeterminationPrixTransfert  ;
		 @Column
			String ChangementMethodeDeterminationPrixTransfert  ;
			 @Column
				String ChnagementAutreMethodeDeterminationPrixTransfert  ;
		 
	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getAchatsDepenses() {
		return AchatsDepenses;
	}

	public void setAchatsDepenses(String achatsDepenses) {
		AchatsDepenses = achatsDepenses;
	}

	public String getVentesRevenus() {
		return VentesRevenus;
	}

	public void setVentesRevenus(String ventesRevenus) {
		VentesRevenus = ventesRevenus;
	}

	

	public String getRaisonSociale() {
		return RaisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}

	

	

	public String getNatureOperation() {
		return NatureOperation;
	}

	public void setNatureOperation(String natureOperation) {
		NatureOperation = natureOperation;
	}

	public String getAutreNatureOperation() {
		return AutreNatureOperation;
	}

	public void setAutreNatureOperation(String autreNatureOperation) {
		AutreNatureOperation = autreNatureOperation;
	}

	public String getIdentifiant() {
		return Identifiant;
	}

	public void setIdentifiant(String identifiant) {
		Identifiant = identifiant;
	}

	public String getEtatTerritoire() {
		return EtatTerritoire;
	}

	public void setEtatTerritoire(String etatTerritoire) {
		EtatTerritoire = etatTerritoire;
	}

	public String getMatriculeFiscal() {
		return MatriculeFiscal;
	}

	public void setMatriculeFiscal(String matriculeFiscal) {
		MatriculeFiscal = matriculeFiscal;
	}

	public String getQualite() {
		return Qualite;
	}

	public void setQualite(String qualite) {
		Qualite = qualite;
	}

	public String getAutreQualite() {
		return AutreQualite;
	}

	public void setAutreQualite(String autreQualite) {
		AutreQualite = autreQualite;
	}

	public String getNatureRelation() {
		return NatureRelation;
	}

	public void setNatureRelation(String natureRelation) {
		NatureRelation = natureRelation;
	}

	public String getAutreNatureRelation() {
		return AutreNatureRelation;
	}

	public void setAutreNatureRelation(String autreNatureRelation) {
		AutreNatureRelation = autreNatureRelation;
	}

	public String getMethodeDeterminationPrixTransfert() {
		return MethodeDeterminationPrixTransfert;
	}

	public void setMethodeDeterminationPrixTransfert(String methodeDeterminationPrixTransfert) {
		MethodeDeterminationPrixTransfert = methodeDeterminationPrixTransfert;
	}

	public String getAutreMethodeDeterminationPrixTransfert() {
		return AutreMethodeDeterminationPrixTransfert;
	}

	public void setAutreMethodeDeterminationPrixTransfert(String autreMethodeDeterminationPrixTransfert) {
		AutreMethodeDeterminationPrixTransfert = autreMethodeDeterminationPrixTransfert;
	}

	public String getChangementMethodeDeterminationPrixTransfert() {
		return ChangementMethodeDeterminationPrixTransfert;
	}

	public void setChangementMethodeDeterminationPrixTransfert(String changementMethodeDeterminationPrixTransfert) {
		ChangementMethodeDeterminationPrixTransfert = changementMethodeDeterminationPrixTransfert;
	}

	public String getChnagementAutreMethodeDeterminationPrixTransfert() {
		return ChnagementAutreMethodeDeterminationPrixTransfert;
	}

	public void setChnagementAutreMethodeDeterminationPrixTransfert(
			String chnagementAutreMethodeDeterminationPrixTransfert) {
		ChnagementAutreMethodeDeterminationPrixTransfert = chnagementAutreMethodeDeterminationPrixTransfert;
	}

	public InformationsServicesBD getInformationsServices() {
		return InformationsServices;
	}

	public void setInformationsServices(InformationsServicesBD informationsServices) {
		InformationsServices = informationsServices;
	}

	
	 @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name ="InformationsServices", referencedColumnName = "id")
	    private InformationsServicesBD InformationsServices;

}