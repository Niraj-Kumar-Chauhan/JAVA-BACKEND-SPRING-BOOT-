package in.nirajarmy.transaction_day_27.repository;

import in.nirajarmy.transaction_day_27.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
