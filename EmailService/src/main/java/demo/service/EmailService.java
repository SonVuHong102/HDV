package demo.service;

import demo.dto.request.email.EmailReq;
import demo.dto.response.email.EmailRes;

public interface EmailService {
    EmailRes sendSimpleMessage(EmailReq emailReq);
}
