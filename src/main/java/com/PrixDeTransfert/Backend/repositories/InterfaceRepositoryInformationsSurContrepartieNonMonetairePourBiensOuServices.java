package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;



public interface InterfaceRepositoryInformationsSurContrepartieNonMonetairePourBiensOuServices extends JpaRepository<InformationsSurContrepartieNonMonetairePourBiensOuServicesBD,Long> {
	InformationsSurContrepartieNonMonetairePourBiensOuServicesBD findInformationsSurContrepartieNonMonetairePourBiensOuServicesBDById(Long idInformationsSurContrepartieNonMonetairePourBiensOuServices);
}
