package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.User;

public interface InterfaceRepositoryUser extends JpaRepository<User,Long> {
	 User findByEmail(String email);
	 User findUserById(Long iduser);

}
