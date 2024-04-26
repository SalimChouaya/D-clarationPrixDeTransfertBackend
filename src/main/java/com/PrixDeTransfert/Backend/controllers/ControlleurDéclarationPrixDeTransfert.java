package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;

import jakarta.servlet.http.HttpSession;


@RestController
public class ControlleurDéclarationPrixDeTransfert {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceDéclarationPrixDeTransfert ServiceDéclarationPrixDeTransfert;
	
	@PostMapping("/DéclarationPrixDeTransfert")
	public DéclarationPrixDeTransfert save(@RequestBody DéclarationPrixDeTransfert a,HttpSession session) {
		Long entrepriseid=(Long) session.getAttribute("entrepriseId");
		DéclarationPrixDeTransfert Declaration =ServiceDéclarationPrixDeTransfert.save(a,entrepriseid);
		session.setAttribute("Déclarationid", Declaration.getId());
		return Declaration;
		
	}
	
}