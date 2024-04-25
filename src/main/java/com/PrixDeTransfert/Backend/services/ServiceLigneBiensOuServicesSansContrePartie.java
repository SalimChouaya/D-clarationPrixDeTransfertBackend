package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.LigneBiensOuServicesSansContrePartieBD;

@Service
public class ServiceLigneBiensOuServicesSansContrePartie {
 @Autowired
 com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneBiensOuServicesSansContrePartie InterfaceRepositoryLigneBiensOuServicesSansContrePartie;
 @Autowired
 com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie ;
 public LigneBiensOuServicesSansContrePartieBD save(LigneBiensOuServicesSansContrePartieBD a , Long IdInformationsSurBiensOuServicesSansContrePartie) {
 InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartie=InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie.findInformationsSurBiensOuServicesSansContrePartieBDById(IdInformationsSurBiensOuServicesSansContrePartie);
 a.setInformationsSurBiensOuServicesSansContrePartie(InformationsSurBiensOuServicesSansContrePartie);
 return InterfaceRepositoryLigneBiensOuServicesSansContrePartie.save(a);
}
}