package me.saechimdaeki.security.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account implements Serializable {


    @Id @GeneratedValue
    private Long id;

    private String userName;

    private String password;

    private String email;

    private int age;

    private String role;

    private Account(String userName, String password, String email, int age, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.role = role;
    }

    public static Account createNewAccount(AccountDto accountDto){
        return new Account(accountDto.getUserName(), accountDto.getPassword(), accountDto.getEmail(), accountDto.getAge(), accountDto.getRole());
    }
}
