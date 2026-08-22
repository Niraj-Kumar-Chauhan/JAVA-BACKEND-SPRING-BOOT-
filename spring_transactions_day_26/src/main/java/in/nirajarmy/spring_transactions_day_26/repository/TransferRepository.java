package in.nirajarmy.spring_transactions_day_26.repository;

import in.nirajarmy.spring_transactions_day_26.model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {

}
