package com.ale.safepass.safepass.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ale.safepass.safepass.exception.PasswordNotFoundException;
import com.ale.safepass.safepass.exception.PasswordServiceException;
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
	        if (password.getHashPassword() == null || password.getHashPassword().isBlank()) {
	            throw new IllegalArgumentException("password cannot be empty");
	        }
	        password.setHashPassword(encoder.encode(password.getHashPassword()));
	        return repository.save(password);
	    }

	    public Password findByService(String serviceName) {
	        return repository.findByService(serviceName)
	                .orElseThrow(() -> new PasswordNotFoundException("Password not found for service " + serviceName));
	    }
	    public void delete(String id) {
	        try {
	            repository.deleteById(id);
	        } catch (Exception e) {
	            throw new PasswordServiceException("Error deleting password with id: " + id);
	        }
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


