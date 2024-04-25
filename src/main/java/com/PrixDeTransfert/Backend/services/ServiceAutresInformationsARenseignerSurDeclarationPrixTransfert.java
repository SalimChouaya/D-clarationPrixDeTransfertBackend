package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert;
import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryAutresInformationsARenseignerSurDeclarationPrixTransfert;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert;
@Service
public class ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert {
	@Autowired
	InterfaceRepositoryAutresInformationsARenseignerSurDeclarationPrixTransfert InterfaceRepositoryAutresInformationsARenseignerSurDeclarationPrixTransfert;
	@Autowired
	InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert ;
	AutresInformationsARenseignerSurDeclarationPrixTransfert save (AutresInformationsARenseignerSurDeclarationPrixTransfert a ,Long iddéclarations) {
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert=InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddéclarations);
		a.setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert);
		return InterfaceRepositoryAutresInformationsARenseignerSurDeclarationPrixTransfert.save(a);
	}

}
