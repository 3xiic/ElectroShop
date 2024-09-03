package co.edu.unbosque.ElectroShop.service;

import java.util.Set;

import co.edu.unbosque.ElectroShop.model.Category;
import co.edu.unbosque.ElectroShop.model.CategoryDTO;
import co.edu.unbosque.ElectroShop.model.Client;
import co.edu.unbosque.ElectroShop.model.ClientDTO;
import co.edu.unbosque.ElectroShop.model.Detail;
import co.edu.unbosque.ElectroShop.model.DetailDTO;
import co.edu.unbosque.ElectroShop.model.Order;
import co.edu.unbosque.ElectroShop.model.OrderDTO;
import co.edu.unbosque.ElectroShop.model.Product;
import co.edu.unbosque.ElectroShop.model.ProductDTO;

public class DataMapper {
	
	public static CategoryDTO categoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO  = new CategoryDTO();
		Set<ProductDTO> productDTOs = null;
		categoryDTO.setCategory_id(category.getCategory_id());
		categoryDTO.setCategory_name(category.getCategory_name());
		categoryDTO.setCategory_description(category.getCategory_description());
		
		for (Product product : category.getProducts())	{
			productDTOs.add(productToProductDTO(product));
		}
		categoryDTO.setProducts(productDTOs);
		return categoryDTO;
	}
	
	public static Category categoryDTOToCategory(CategoryDTO categoryDTO) {
		Category category  = new Category();
		Set<Product> products = null;
		category.setCategory_id(categoryDTO.getCategory_id());
		category.setCategory_name(categoryDTO.getCategory_name());
		category.setCategory_description(categoryDTO.getCategory_description());
		category.setCategory_description(categoryDTO.getCategory_description());
		
		for (ProductDTO productDTO : categoryDTO.getProducts())	{
			products.add(productDTOToProduct(productDTO));
		}
		
		category.setProducts(products);
		return category;
	}
	
	public static ClientDTO clientToClientDTO( Client client) {
		ClientDTO clientDTO = new ClientDTO();
		Set<OrderDTO> orderDTOs = null;
		clientDTO.setClient_id(client.getClient_id());
		clientDTO.setClient_name(client.getClient_name());
		clientDTO.setClient_lastname(client.getClient_lastname());
		clientDTO.setAddress(client.getAddress());
		clientDTO.setPhone_number(client.getPhone_number());
		
		for (Order order : client.getOrders()) {
			orderDTOs.add(orderToOrderDTO(order));
		}
		
		clientDTO.setOrders(orderDTOs);
		
		return clientDTO;
	}
	
	public static Client clientDTOToClient( ClientDTO clientDTO) {
		Client client = new Client();
		Set<Order> orders = null;
		client.setClient_id(clientDTO.getClient_id());
		client.setClient_name(clientDTO.getClient_name());
		client.setClient_lastname(clientDTO.getClient_lastname());
		client.setAddress(clientDTO.getAddress());
		client.setPhone_number(clientDTO.getPhone_number());
		
		for (OrderDTO orderDTO : clientDTO.getOrders()) {
			orders.add(orderDTOToOrder(orderDTO));
		}
		
		client.setOrders(orders);
		
		return client;
	}
	
	public static DetailDTO detailToDetailDTO(Detail detail) {
		DetailDTO detailDTO = new DetailDTO();		
		detailDTO.setDetails_id(detail.getDetails_id());
		detailDTO.setAmount(detail.getAmount());
		detailDTO.setOrder(detail.getOrder());
		detailDTO.setProduct(detail.getProduct());
		return detailDTO;
		
	}
	
	public static Detail detailDTOToDetail(DetailDTO detailDTO) {
		Detail detail = new Detail();		
		detail.setDetails_id(detailDTO.getDetails_id());
		detail.setAmount(detailDTO.getAmount());
		detail.setOrder(detailDTO.getOrder());
		detail.setProduct(detailDTO.getProduct());
		return detail;
		
	}
	public static OrderDTO orderToOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		Set<DetailDTO> detailsDTO = null;
		orderDTO.setOrder_id(order.getOrder_id());
		orderDTO.setFecha(order.getFecha());
		orderDTO.setTotal_pay(order.getTotal_pay());
		orderDTO.setClient(order.getClient());
		orderDTO.setClient(order.getClient());
		
		for (Detail detail : order.getDetails()) {
			detailsDTO.add(detailToDetailDTO(detail));
		}
		
		orderDTO.setDetails(detailsDTO);
		
		return orderDTO;
	}
	public static Order orderDTOToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		Set<Detail> details = null;
		order.setOrder_id(orderDTO.getOrder_id());
		order.setFecha(orderDTO.getFecha());
		order.setTotal_pay(orderDTO.getTotal_pay());
		order.setClient(orderDTO.getClient());
		
		for (DetailDTO detailDTO : orderDTO.getDetails()) {
			details.add(detailDTOToDetail(detailDTO));
		}
		
		order.setDetails(details);
		
		return order;
	}
	public static ProductDTO productToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		Set<DetailDTO> detailsDTO = null;
		productDTO.setProduct_id(product.getProduct_id());
		productDTO.setProduct_name(product.getProduct_name());
		productDTO.setPrice(product.getPrice());
		productDTO.setStock(product.getStock());
		productDTO.setCategory(product.getCategory());
		
		for (Detail detail: product.getDetails()) {
			detailsDTO.add(detailToDetailDTO(detail));
		}
		productDTO.setDetails(detailsDTO);
		
		return productDTO;
	}
	public static Product productDTOToProduct(ProductDTO productDTO) {
		Product product = new Product();
		Set<Detail> details = null;
		product.setProduct_id(productDTO.getProduct_id());
		product.setProduct_name(productDTO.getProduct_name());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setCategory(productDTO.getCategory());
		
		for (DetailDTO detailDTO: productDTO.getDetails()) {
			details.add(detailDTOToDetail(detailDTO));
		}
		product.setDetails(details);
		return product;
	}
	
}
