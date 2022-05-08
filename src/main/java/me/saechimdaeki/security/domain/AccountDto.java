package me.saechimdaeki.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String userName;

    private String password;

    private String email;

    private int age;

    private String role;


    public void changePassword(String password){
        this.password= password;
    }
}
