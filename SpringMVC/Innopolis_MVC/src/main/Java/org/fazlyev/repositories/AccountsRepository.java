package org.fazlyev.repositories;

import org.fazlyev.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account,Long> {
}
