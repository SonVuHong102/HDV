package demo.service.impl;


import demo.dto.request.payment.PaymentReq;
import demo.dto.response.payment.PaymentRes;
import demo.service.PaymentService;
import demo.utils.Constants;
import demo.utils.exception.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentRes payment(PaymentReq paymentReq) throws ApplicationException {
        PaymentRes paymentRes;
        String uri = "http://localhost:8084/wallet/payment";
        RestTemplate restTemplate = new RestTemplate();
        paymentRes = restTemplate.postForObject(uri,paymentReq, PaymentRes.class);
        if(paymentRes == null || paymentRes.getStatus().compareTo(Constants.STATUS_ERROR) == 0)
            throw new ApplicationException("ERR_0000");
        return paymentRes;
    }
}
