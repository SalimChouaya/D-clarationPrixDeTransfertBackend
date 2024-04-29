package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.dto.SignInRequest;
import com.PrixDeTransfert.Backend.dto.SignUpRequest;
import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.services.ServiceUser;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerAuthentification {
	@Autowired
    private ServiceUser userService;
    

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody SignUpRequest signUpRequest ,HttpSession session) {
	    // Vérifier si l'utilisateur existe déjà dans la base de données
	    User existingUser = userService.findByEmail(signUpRequest.getEmail());
	    if (existingUser != null) {
	        return new ResponseEntity<>("Adresse e-mail déjà utilisée", HttpStatus.BAD_REQUEST);
	    }

	    // Créer un nouvel utilisateur à partir des données de la requête
	    User user = new User();
	    user.setUsername(signUpRequest.getUsername());
	    user.setPassword(signUpRequest.getPassword());
	    user.setEmail(signUpRequest.getEmail());
        
	    User saveduser=userService.saveUser(user);
	    session.setAttribute("iduser", saveduser.getId());

	    return new ResponseEntity<>("Utilisateur enregistré avec succès", HttpStatus.CREATED);
	}
    

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody SignInRequest signInRequest ,HttpSession session) {
        // Récupérer l'utilisateur à partir de l'adresse e-mail
        User user = userService.findByEmail(signInRequest.getEmail());
        
        // Vérifier si l'utilisateur existe et si le mot de passe est correct
        if (user == null || !user.getPassword().equals(signInRequest.getPassword())) {
            return new ResponseEntity<>("Adresse e-mail ou mot de passe incorrect", HttpStatus.UNAUTHORIZED);
        }
         session.setAttribute("iduser", user.getId());
         
        return new ResponseEntity<>("Connexion réussie", HttpStatus.OK);
    }
}
