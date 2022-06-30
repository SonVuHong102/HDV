package demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wallettbl")
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Wallet extends BaseEntity {
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String phone;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String email;
}
