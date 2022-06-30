package demo.controller;


import demo.dto.request.payment.PaymentReq;
import demo.dto.response.payment.PaymentRes;
import demo.form.InputForm;
import demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import demo.service.PaymentService;
import demo.utils.exception.ApplicationException;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@RequestMapping("/")
public class MainController extends BaseController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("")
    public String input(Model model) {
        InputForm inputForm = new InputForm();
        model.addAttribute("inputForm",inputForm);
        return "tmdt";
    }

    @PostMapping(value = "/payment")
    public String payment(Model model,
                      HttpServletRequest request,
                      @ModelAttribute("inputForm") InputForm inputForm) throws ApplicationException {
        PaymentReq paymentReq = new PaymentReq();
        paymentReq.setUsername(inputForm.getUsername());
        paymentReq.setPhone(inputForm.getPhone());
        paymentReq.setPassword(inputForm.getPassword());
        paymentReq.setEmail(inputForm.getEmail());
        paymentReq.setAmount(inputForm.getAmount());
        paymentReq.setReturnURL(inputForm.getReturnURL());
        PaymentRes paymentRes = paymentService.payment(paymentReq);
        if(paymentRes.getStatus() != null || paymentRes.getStatus().compareTo(Constants.STATUS_DONE) == 0)  {
            return paymentReq.getReturnURL();
        }
        return "errorPage";
    }

    @GetMapping("result")
    public String result() {
        return "result";
    }

}
