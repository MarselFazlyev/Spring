package org.fazlyev.services;

import org.fazlyev.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.fazlyev.models.Account;
import org.springframework.stereotype.Service;
import org.fazlyev.repositories.AccountsRepository;


@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final AccountsRepository accountsRepository;

    public void signUp(AccountDTO accountDTO) {
        Account account = Account.builder()
                .firstName(accountDTO.getFirstName())
                .lastName(accountDTO.getLastName())
                .email(accountDTO.getEmail())
                .password(accountDTO.getPassword())
                .build();

        accountsRepository.save(account);

    }
}
