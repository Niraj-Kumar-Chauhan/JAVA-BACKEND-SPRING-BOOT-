package in.nirajarmy.spring_transactions_day_26.repository;

import in.nirajarmy.spring_transactions_day_26.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
