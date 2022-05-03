package me.saechimdaeki.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class AccountDto {

    private String userName;

    private String password;

    private String email;

    private String age;

    private String role;


    public void changePassword(String password){
        this.password= password;
    }
}
