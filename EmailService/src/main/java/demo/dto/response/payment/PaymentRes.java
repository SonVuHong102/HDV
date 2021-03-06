package demo.dto.response.payment;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import demo.dto.response.IResponseData;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PaymentRes implements IResponseData {
    String status;
}
