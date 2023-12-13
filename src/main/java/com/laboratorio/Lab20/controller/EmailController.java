package com.laboratorio.Lab20.controller;

import com.laboratorio.Lab20.handler.Message;
import com.laboratorio.Lab20.model.DTO.EmailDTO;
import com.laboratorio.Lab20.service.IEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarCorreo(@Valid @RequestBody EmailDTO emailDTO, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            String errorMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            return new ResponseEntity<>(new Message(errorMessage), HttpStatus.BAD_REQUEST);
        }

        EmailDTO email = new EmailDTO();
        email.setName(emailDTO.getName());
        email.setEmail(emailDTO.getEmail());
        email.setMessage(emailDTO.getMessage());


        System.out.println("Mensaje Recibido " + email);

        try {
            emailService.sendEmail(email);
            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            return ResponseEntity.ok(response);
        } catch (MailSendException e) {
            String errorMessage = "Error al enviar el correo. Verifique la dirección de correo electrónico.";
            return new ResponseEntity<>(new Message(errorMessage), HttpStatus.BAD_REQUEST);
        }
    }
}
