package demo.service.impl;


import demo.dto.request.email.EmailReq;
import demo.dto.response.email.EmailRes;
import demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import demo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public EmailRes sendSimpleMessage(EmailReq emailReq) {
        EmailRes emailRes = new EmailRes();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("johncoldman.123@gmail.com");
        message.setTo(emailReq.getAddress());
        message.setSubject(emailReq.getTitle());
        message.setText(emailReq.getMessage());
        emailSender.send(message);
        emailRes.setStatus(Constants.STATUS_DONE);
        return emailRes;
    }
}
