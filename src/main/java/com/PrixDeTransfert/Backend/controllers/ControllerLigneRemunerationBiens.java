package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneRemunerationBiens;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneRemunerationBiens {
	@Autowired
	private ServiceLigneRemunerationBiens LigneRemunerationBiens ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsRemunerationsBiensCorporelsIncorporels/LigneRemunerationBiens")
	public LigneRemunerationBiensBD save(@RequestBody LigneRemunerationBiensBD  a,HttpSession session) {
		Long idInformationsRemunerationsBiensCorporelsIncorporels=(Long) session.getAttribute("idInformationsRemunerationsBiensCorporelsIncorporels");
		return LigneRemunerationBiens.save(a, idInformationsRemunerationsBiensCorporelsIncorporels);}

}
