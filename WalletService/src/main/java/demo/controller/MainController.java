package demo.controller;


import demo.dto.request.wallet.WalletReq;
import demo.dto.response.wallet.WalletRes;
import demo.service.WalletService;
import demo.utils.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/wallet")
public class MainController extends BaseController {

    @Autowired
    WalletService walletService;

    @PostMapping(value = "/payment")
    @ResponseBody
    public WalletRes payment(@RequestBody WalletReq walletReq) throws ApplicationException {
        return walletService.payment(walletReq);
    }

}
