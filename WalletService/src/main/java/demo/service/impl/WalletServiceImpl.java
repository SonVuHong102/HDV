package demo.service.impl;

import demo.dto.request.wallet.WalletReq;
import demo.dto.response.wallet.WalletRes;
import demo.model.Wallet;
import demo.repository.WalletRepository;
import demo.service.WalletService;
import demo.utils.Constants;
import demo.utils.exception.ApplicationException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public WalletRes payment(WalletReq walletReq) throws ApplicationException {
        WalletRes walletRes = new WalletRes();
        walletRes.setStatus(Constants.STATUS_ERROR);
        Wallet wallet = walletRepository.getWallet(walletReq.getUsername(),walletReq.getPhone(),walletReq.getPassword(),walletReq.getEmail());
        if(wallet == null) {
            throw new ApplicationException("ERR_0000");
        }
        String uri = "http://localhost:8085/email/send";
        RestTemplate restTemplate = new RestTemplate();
        EmailReq emailReq = new EmailReq();
        emailReq.setTitle("Thanh toán thành công");
        emailReq.setAddress(walletReq.getEmail());
        emailReq.setMessage("Thamh toán thành công");
        walletRes = restTemplate.postForObject(uri,emailReq, WalletRes.class);
        if(walletRes == null || walletRes.getStatus().compareTo(Constants.STATUS_ERROR) == 0) {
            throw new ApplicationException("ERR_0000");
        }
        walletRes.setStatus(Constants.STATUS_DONE);
        return walletRes;
    }
}

@Data
class EmailReq {
    String address;
    String title;
    String message;
}
