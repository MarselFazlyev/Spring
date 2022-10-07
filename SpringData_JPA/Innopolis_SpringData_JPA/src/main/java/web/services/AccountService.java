package web.services;

import web.dto.SignUpForm;
import web.models.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    void createAccount(SignUpForm dto);
}
