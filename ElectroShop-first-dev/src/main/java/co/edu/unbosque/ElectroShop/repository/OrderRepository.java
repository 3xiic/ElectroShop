package co.edu.unbosque.ElectroShop.repository;

import co.edu.unbosque.ElectroShop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {

}
