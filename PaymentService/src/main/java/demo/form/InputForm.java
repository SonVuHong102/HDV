package demo.form;

import lombok.Data;

@Data
public class InputForm {
    private String username;
    private String phone;
    private String password;
    private String email;
    private String amount;
    private String returnURL;
}
