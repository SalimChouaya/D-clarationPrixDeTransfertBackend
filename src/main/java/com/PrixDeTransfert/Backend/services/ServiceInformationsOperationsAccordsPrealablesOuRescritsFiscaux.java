package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;

@Service
public class ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux ;
	@Autowired 
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperations InterfaceRepositoryInformationsOperations ;
	 
	public InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD save(InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD a,Long idInformationsOperations) {
		InformationsOperationsBD InformationsOperations=InterfaceRepositoryInformationsOperations.findInformationsOperationsBDById(idInformationsOperations);
		a.setInformationsOperations(InformationsOperations);
		return InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux.save(a);
	}

}