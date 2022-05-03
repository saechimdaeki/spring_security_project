package me.saechimdaeki.security.service.impl;

import lombok.RequiredArgsConstructor;
import me.saechimdaeki.security.domain.Account;
import me.saechimdaeki.security.domain.AccountDto;
import me.saechimdaeki.security.repository.UserRepository;
import me.saechimdaeki.security.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Transactional
    @Override
    public void createUser(AccountDto accountDto) {
        userRepository.save(Account.createNewAccount(accountDto));
    }
}
