package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Order;
import co.edu.unbosque.ElectroShop.model.OrderDTO;

import co.edu.unbosque.ElectroShop.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public OrderService() {
	
	}

	/**
	 * Saves an order to the database.
	 *
	 * @param  orderDTO  the order to be saved
	 * @return       true if the order is saved successfully, false otherwise
	 */
	public boolean saveOrder(OrderDTO orderDTO) {
		try {
			orderRepository.save(DataMapper.orderDTOToOrder(orderDTO));
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves an Order object from the database based on the provided id.
	 *
	 * @param id the id of the Order to be retrieved
	 * @return the Order object if found, otherwise null
	 */
	@Cacheable(value = "orderCache", key = "#id")
	public OrderDTO getOrder(long id) {
		if (orderRepository.findById(id).isPresent()) {
			return DataMapper.orderToOrderDTO(orderRepository.findById(id).get());
		}
		return null;
	}

    /**
     * Saves multiple orders to the database.
     *
     * @param  orders  the list of orders to be saved
     * @return        true if all orders were saved successfully, false otherwise
     */
    public boolean saveAll(List<OrderDTO> orders) {
		try {
			for (OrderDTO orderDTO : orders) {
				orderRepository.save(DataMapper.orderDTOToOrder(orderDTO));
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return  a list of all orders in the database
     */
    public List<OrderDTO> getAllOrders() {
		Iterable<Order> orders = orderRepository.findAll();
		List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(DataMapper.orderToOrderDTO(order));
        }
		return orderDTOs;
    }



    /**
     * Marks an order as paid.
     *
     * @param order the order to be marked as paid
     */
	public void paidOrder(OrderDTO order) {
		order.setPaid(true);
		orderRepository.save(DataMapper.orderDTOToOrder(order));
	}
}
