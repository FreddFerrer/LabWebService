package com.laboratorio.Lab20.service;

import com.laboratorio.Lab20.model.DTO.EmailDTO;

public interface IEmailService {
    void sendEmail(EmailDTO email);
}
