package demo.service;


import demo.dto.request.wallet.WalletReq;
import demo.dto.response.wallet.WalletRes;
import demo.repository.WalletRepository;
import demo.utils.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {
    WalletRes payment(WalletReq walletReq) throws ApplicationException;
}
