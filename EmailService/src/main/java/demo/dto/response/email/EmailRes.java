package demo.dto.response.email;

import demo.dto.response.IResponseData;
import lombok.Data;

@Data
public class EmailRes implements IResponseData {
    String status;
}
