package com.PrixDeTransfert.Backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.Entreprise;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte;
@Service
public class ServiceCreerCompte {
  @Autowired
	private InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
  
	public Entreprise save(Entreprise a) {
		return InterfaceRepositoryCreerCompte.save(a);
		
	}

	public Entreprise findEntrepriseById(Long a) {
	
	 return InterfaceRepositoryCreerCompte.findEntrepriseById(a);
	}


	


	


	

}
