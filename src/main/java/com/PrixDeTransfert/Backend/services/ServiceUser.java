package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryUser;

@Service
public class ServiceUser {
	@Autowired
    private InterfaceRepositoryUser userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
