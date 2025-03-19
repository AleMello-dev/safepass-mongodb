package com.ale.safepass.safepass.controller;

import java.util.List;

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
    public List<Password> listAll() {
        return service.listAll();
    }

    @PostMapping
    public Password save(@RequestBody Password password) {
        return service.save(password);
    }

    @GetMapping("/service/{serviceName}")
    public Password findByService(@PathVariable String serviceName) {
        return service.findByService(serviceName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/generate")
    public String generatePassword(@PathVariable int size) {
        return service.generatePassword(size);
    }
}
