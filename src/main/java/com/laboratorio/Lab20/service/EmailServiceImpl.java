package com.laboratorio.Lab20.service;

import com.laboratorio.Lab20.model.DTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ferreirafreddy39@gmail.com");
        message.setTo("freddysoldev@gmail.com");
        message.setSubject("Nuevo mensaje de " + emailDTO.getName());
        message.setText("Correo de: " + emailDTO.getEmail() + "\n\n" + emailDTO.getMessage());

        mailSender.send(message);
    }
}
