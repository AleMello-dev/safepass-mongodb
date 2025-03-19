package com.ale.safepass.safepass.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ale.safepass.safepass.model.Password;

public interface PasswordRepository extends MongoRepository<Password, String> {
	Optional<Password> findByService(String service);
}
