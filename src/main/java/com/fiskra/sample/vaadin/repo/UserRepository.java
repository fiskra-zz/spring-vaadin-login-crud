package com.fiskra.sample.vaadin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiskra.sample.vaadin.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	//User findOne(String userName,String password);
	User findByUserNameAndPassword(String userName,String password);

}
