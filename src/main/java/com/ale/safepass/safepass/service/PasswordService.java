package com.ale.safepass.safepass.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ale.safepass.safepass.model.Password;
import com.ale.safepass.safepass.repository.PasswordRepository;

@Service
public class PasswordService {
	

	    private final PasswordRepository repository;
	    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	    public PasswordService(PasswordRepository repository) {
	        this.repository = repository;
	    }

	    public List<Password> listAll() {
	        return repository.findAll();
	    }

	    public Password save(Password password) {
	    	password.setHashPassword(encoder.encode(password.getHashPassword())); 
	        return repository.save(password);
	    }

	    public Optional<Password> findByService(String service) {
	        return repository.findByService(service);
	    }

	    public void delete(String id) {
	        repository.deleteById(id);
	    }

	    public String generatePassword (int size) {
	        String caracters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*!?";
	        SecureRandom random = new SecureRandom();
	        StringBuilder generatedPassword = new StringBuilder(size);

	        for (int i = 0; i < size; i++) {
	        	generatedPassword.append(caracters.charAt(random.nextInt(caracters.length())));
	        }
	        return generatedPassword.toString();
	    }
	}


