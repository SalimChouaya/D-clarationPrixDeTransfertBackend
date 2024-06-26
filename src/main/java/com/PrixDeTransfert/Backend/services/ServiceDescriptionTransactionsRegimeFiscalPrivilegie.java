package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDescriptionTransactionsRegimeFiscalPrivilegie;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.DescriptionTransactionsRegimeFiscalPrivilegie;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
@Service
public class ServiceDescriptionTransactionsRegimeFiscalPrivilegie {
	@Autowired
	ServiceMontantTransactionsMethodeDeterminationPrixTransfert service;
    @Autowired
    InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert b;
    @Autowired
    InterfaceRepositoryDescriptionTransactionsRegimeFiscalPrivilegie InterfaceRepositoryDescriptionTransactionsRegimeFiscalPrivilegie;
	
	public DescriptionTransactionsRegimeFiscalPrivilegie save(DescriptionTransactionsRegimeFiscalPrivilegie a, Long IdMontantTransactions) {
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=b.findMontantTransactionsMethodeDeterminationPrixTransfertBDById(IdMontantTransactions);
		a.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
		return InterfaceRepositoryDescriptionTransactionsRegimeFiscalPrivilegie.save(a);
	}
}
