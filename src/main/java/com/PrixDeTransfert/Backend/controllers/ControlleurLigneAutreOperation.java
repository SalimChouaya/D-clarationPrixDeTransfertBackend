package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;
import com.PrixDeTransfert.Backend.services.ServiceDescriptionTransactionsRegimeFiscalPrivilegie;
import com.PrixDeTransfert.Backend.services.ServiceLigneAutreOperation;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControlleurLigneAutreOperation {
	@Autowired
	private ServiceLigneAutreOperation LigneAutreOperation ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsAutresOperations/LigneAutreOperation")
	public LigneAutreOperationBD save(@RequestBody LigneAutreOperationBD  a,HttpSession session) {
		Long idInformationsAutresOperations =(Long) session.getAttribute("idInformationsAutresOperations");
		return LigneAutreOperation.save(a, idInformationsAutresOperations);}
	@Autowired 
	private ServiceDescriptionTransactionsRegimeFiscalPrivilegie DescriptionTransactionsRegimeFiscalPrivilegie;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/DescriptionTransactionsRegimeFiscalPrivilegie")
	public com.PrixDeTransfert.Backend.models.DescriptionTransactionsRegimeFiscalPrivilegie save(@RequestBody com.PrixDeTransfert.Backend.models.DescriptionTransactionsRegimeFiscalPrivilegie  a,HttpSession session) {
		Long idMontantTransactions=(Long) session.getAttribute("idMontantTransactions");
		return DescriptionTransactionsRegimeFiscalPrivilegie.save(a, idMontantTransactions);}
	
	
}
