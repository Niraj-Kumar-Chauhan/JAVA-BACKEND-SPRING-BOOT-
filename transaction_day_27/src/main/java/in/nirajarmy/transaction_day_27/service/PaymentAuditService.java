package in.nirajarmy.transaction_day_27.service;


import in.nirajarmy.transaction_day_27.model.Order;
import in.nirajarmy.transaction_day_27.model.PaymentAudit;
import in.nirajarmy.transaction_day_27.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService
            (
                    PaymentAuditRepository paymentAuditRepository
            ) {
        this.paymentAuditRepository = paymentAuditRepository;
    }


    @Transactional(
            propagation = Propagation.NEVER,
            isolation = Isolation.REPEATABLE_READ
    )
    public void audit (Order order) {

        PaymentAudit paymentAudit = new PaymentAudit
                (
                        order.getAmount(),
                        order.getId(),
                        true
                );

        paymentAuditRepository.save(paymentAudit);

        //throw new RuntimeException("something went wrong");
    }
}
