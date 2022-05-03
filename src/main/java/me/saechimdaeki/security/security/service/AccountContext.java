package me.saechimdaeki.security.security.service;

import lombok.Getter;
import me.saechimdaeki.security.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
public class AccountContext extends User {


    private final Account account;


    public AccountContext(Account account,
                          Collection<? extends GrantedAuthority> authorities) {

        super(account.getUserName(),account.getPassword() , authorities);

        this.account = account;
    }


}
