package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;


@RestController
public class ControlleurDéclarationPrixDeTransfert {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceDéclarationPrixDeTransfert ServiceDéclarationPrixDeTransfert;
	
	@PostMapping("/DéclarationPrixDeTransfert/{Entreprise-id}")
	public DéclarationPrixDeTransfert save(@RequestBody DéclarationPrixDeTransfert a,@PathVariable("Entreprise-id") Long entrepriseid) {
		return ServiceDéclarationPrixDeTransfert.save(a,entrepriseid);
		
	}
	
}