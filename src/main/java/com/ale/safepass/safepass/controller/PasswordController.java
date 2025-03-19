package com.ale.safepass.safepass.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ale.safepass.safepass.model.Password;
import com.ale.safepass.safepass.service.PasswordService;

@RestController
@RequestMapping("/password")
public class PasswordController {

	    private final PasswordService service;

	    public PasswordController(PasswordService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Password> listarTodas() {
	        return service.listAll();
	    }

	    @PostMapping
	    public Password salvar(@RequestBody Password password) {
	        return service.save(password);
	    }

	    @GetMapping("/{service}")
	    public Optional<Password> findByService(@PathVariable String service) {
	        return service.findByService(service);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable String id) {
	        service.delete(id);
	    }

	    @GetMapping("/generate/{size}")
	    public String gerarSenha(@PathVariable int size) {
	        return service.generatePassword(size);
	    }
	}


