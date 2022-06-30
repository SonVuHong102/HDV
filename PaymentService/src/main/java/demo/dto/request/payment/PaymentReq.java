package demo.dto.request.payment;


import demo.dto.request.IRequestData;
import demo.model.Payment;
import lombok.Data;

@Data
public class PaymentReq extends Payment implements IRequestData {
}
