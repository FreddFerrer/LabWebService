package com.laboratorio.Lab20.controller;

import com.laboratorio.Lab20.model.DTO.EmailDTO;
import com.laboratorio.Lab20.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarCorreo(@RequestBody EmailDTO emailDTO) {

        EmailDTO email = new EmailDTO();
        email.setName(emailDTO.getName());
        email.setEmail(emailDTO.getEmail());
        email.setMessage(emailDTO.getMessage());

        System.out.println("Mensaje Recibido " + email);

        emailService.sendEmail(email);

        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return ResponseEntity.ok(response);
    }
}
