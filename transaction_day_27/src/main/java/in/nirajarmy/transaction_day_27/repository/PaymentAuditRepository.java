package in.nirajarmy.transaction_day_27.repository;

import in.nirajarmy.transaction_day_27.model.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository
        extends JpaRepository<PaymentAudit, Long> {

}
