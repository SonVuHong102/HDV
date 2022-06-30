package demo.controller;


import demo.dto.request.email.EmailReq;
import demo.dto.response.email.EmailRes;
import demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import demo.utils.exception.ApplicationException;

@Controller
@CrossOrigin
@RequestMapping("/email")
public class MainController extends BaseController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/send")
    @ResponseBody
    public EmailRes payment(@RequestBody EmailReq emailReq) throws ApplicationException {
        return emailService.sendSimpleMessage(emailReq);
    }

}
