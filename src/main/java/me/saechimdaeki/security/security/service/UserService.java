package me.saechimdaeki.security.security.service;

import me.saechimdaeki.security.domain.Account;
import me.saechimdaeki.security.domain.dto.AccountDto;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long idx);

    void order();
}
