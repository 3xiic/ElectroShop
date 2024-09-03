package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * @param  order  the order to be saved
	 * @return       true if the order is saved successfully, false otherwise
	 */
	public boolean saveOrder(Order order) {
		try {
			orderRepository.save(order);
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
	public Order getOrder(long id) {
		if (orderRepository.findById(id).isPresent()) {
			return orderRepository.findById(id).get();
		}
		return null;
	}

	/**
	 * Deletes an order from the database based on the provided id.
	 *
	 * @param  id  the id of the Order to be deleted
	 * @return    true if the order is deleted successfully, false otherwise
	 */
	public boolean deleteOrder(long id) {
		try {
			orderRepository.deleteById(id);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Updates an existing order in the database.
	 *
	 * @param  order  the order to be updated
	 * @return       true if the order is updated successfully, false otherwise
	 */
	public boolean updateOrder(Order order) {
		try {
			orderRepository.save(order);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

    /**
     * Saves multiple orders to the database.
     *
     * @param  orders  the list of orders to be saved
     * @return        true if all orders were saved successfully, false otherwise
     */
    public boolean saveAll(List<Order> orders) {
		try {
			orderRepository.saveAll(orders);
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
    public List<Order> getAllOrders() {
		Iterable<Order> orders = orderRepository.findAll();
		List<Order> orderList = new ArrayList<>();
        for (Order order : orders) {
            orderList.add(order);
        }
		return orderList;
    }
}
