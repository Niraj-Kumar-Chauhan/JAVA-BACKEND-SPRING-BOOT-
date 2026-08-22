package in.nirajarmy.spring_transactions_day_26.service;


import in.nirajarmy.spring_transactions_day_26.model.Account;
import in.nirajarmy.spring_transactions_day_26.model.TransferRecord;
import in.nirajarmy.spring_transactions_day_26.repository.AccountRepository;
import in.nirajarmy.spring_transactions_day_26.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService
            (
                    AccountRepository accountRepository,
                    TransferRepository transferRepository
            ) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    public void transfer
            (
                    Long fromAccountId,
                    Long toAccountId,
                    BigDecimal amount
            ) {
        Account fromAccount = accountRepository
                .findById(fromAccountId)
                .orElseThrow(() -> new  RuntimeException("User not found"));

        Account toAccount = accountRepository
                .findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
//        accountRepository.saveAndFlush(fromAccount);

        toAccount.creditAccount(amount);
//        accountRepository.saveAndFlush(toAccount);

        transferRepository.save
                (
                        new TransferRecord
                                (
                                        fromAccountId,
                                        toAccountId,
                                        amount,
                                        LocalDate.now()
                                )
                );

//        transferRepository.flush();

//        throw new RuntimeException("some error occurred...");
    }
}
