package demo.dto.request.email;

import demo.dto.request.IRequestData;
import demo.model.Email;
import lombok.Data;

@Data
public class EmailReq extends Email implements IRequestData {
}
