package me.saechimdaeki.security.service;

import me.saechimdaeki.security.domain.AccountDto;

public interface UserService {

    void createUser(AccountDto accountDto);
}
