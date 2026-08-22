package in.nirajarmy.spring_transactions_day_26.service;


import in.nirajarmy.spring_transactions_day_26.model.Account;
import in.nirajarmy.spring_transactions_day_26.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void createAccount (Account account) {
        accountRepository.save(account);
    }
}
