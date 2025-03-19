package com.ale.safepass.safepass.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	        try {
	            password.setHashPassword(encoder.encode(password.getHashPassword()));
	            return repository.save(password);
	        } catch (Exception e) {
	            throw new PasswordServiceException("Error saving password for service: " + password.getService());
	        }
	    }

	    public Password findByService(String service) {
	        return repository.findByService(service)
	            .orElseThrow(() -> new PasswordServiceException("Password not found for service: " + service));
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


