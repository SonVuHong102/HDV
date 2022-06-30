package demo.model;

import lombok.Data;

@Data
public class Payment {
    private String username;
    private String phone;
    private String password;
    private String email;
    private String amount;
    private String returnURL;
}
