package com.hungerhelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungerhelp.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
