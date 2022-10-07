package web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.dto.SignUpForm;
import web.models.Account;
import web.repositories.AccountsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    //TODO: дописать методы: findById(), delete()
    private final AccountsRepository accountsRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @Override
    public void createAccount(SignUpForm dto) {
        Account account = Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        accountsRepository.save(account);
    }
}
