package com.example.HauvatarStore.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserClass, Long> {
	UserClass findByUsername(String username);
}