package web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.models.Account;

import java.util.List;

//JpaRepository<СУЩНОСТЬ, ТИП_ИДЕНТИФИКАТОРА_СУЩНОСТИ>
public interface AccountsRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCars_Color(String color);

    @Query("select account from Account account join fetch account.cars car where car.color = :color")
    List<Account> findAllByCarsColor(@Param("color") String color);
}
