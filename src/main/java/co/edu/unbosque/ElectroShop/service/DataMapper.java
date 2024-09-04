package co.edu.unbosque.ElectroShop.service;

import java.util.HashSet;
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
	
	/**
	 * Maps a {@link Category} to a {@link CategoryDTO}.
	 *
	 * @param category the category to be mapped
	 * @return the mapped category
	 */
	public static CategoryDTO categoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO  = new CategoryDTO();
		Set<ProductDTO> productDTOs = new HashSet<>();
		categoryDTO.setCategory_id(category.getCategory_id());
		categoryDTO.setCategory_name(category.getCategory_name());
		categoryDTO.setCategory_description(category.getCategory_description());
		
		for (Product product : category.getProducts())	{
			productDTOs.add(productToProductDTO(product));
		}
		categoryDTO.setProducts(productDTOs);
		return categoryDTO;
	}
	
	/**
	 * Maps a {@link CategoryDTO} to a {@link Category}.
	 *
	 * @param categoryDTO the category DTO to be mapped
	 * @return the mapped category
	 */
	public static Category categoryDTOToCategory(CategoryDTO categoryDTO) {
		Category category  = new Category();
		Set<Product> products = new HashSet<>();
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
	
	/**
	 * Maps a {@link Client} to a {@link ClientDTO}.
	 *
	 * @param client the client to be mapped
	 * @return the mapped client
	 */
	public static ClientDTO clientToClientDTO( Client client) {
		ClientDTO clientDTO = new ClientDTO();
		Set<OrderDTO> orderDTOs = new HashSet<>();
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
	
	/**
	 * Maps a {@link ClientDTO} to a {@link Client}.
	 *
	 * @param clientDTO the client DTO to be mapped
	 * @return the mapped client
	 */
	public static Client clientDTOToClient( ClientDTO clientDTO) {
		Client client = new Client();
		Set<Order> orders = new HashSet<>();
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
	
	/**
	 * Maps a {@link Detail} to a {@link DetailDTO}.
	 *
	 * @param detail the detail to be mapped
	 * @return the mapped detail
	 */
	public static DetailDTO detailToDetailDTO(Detail detail) {
		DetailDTO detailDTO = new DetailDTO();		
		detailDTO.setDetails_id(detail.getDetails_id());
		detailDTO.setAmount(detail.getAmount());
		detailDTO.setOrder(detail.getOrder());
		detailDTO.setProduct(detail.getProduct());
		return detailDTO;
		
	}
	
	/**
	 * Maps a {@link DetailDTO} to a {@link Detail}.
	 *
	 * @param detailDTO the detail DTO to be mapped
	 * @return the mapped detail
	 */
	public static Detail detailDTOToDetail(DetailDTO detailDTO) {
		Detail detail = new Detail();		
		detail.setDetails_id(detailDTO.getDetails_id());
		detail.setAmount(detailDTO.getAmount());
		detail.setOrder(detailDTO.getOrder());
		detail.setProduct(detailDTO.getProduct());
		return detail;
		
	}
	/**
	 * Maps a {@link Order} to a {@link OrderDTO}.
	 *
	 * @param order the order to be mapped
	 * @return the mapped order
	 */
	public static OrderDTO orderToOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		Set<DetailDTO> detailsDTO = new HashSet<>();
		orderDTO.setOrder_id(order.getOrder_id());
		orderDTO.setFecha(order.getFecha());
		orderDTO.setTotal_pay(order.getTotal_pay());
		orderDTO.setClient(order.getClient());
		orderDTO.setPaid(order.isPaid());
		
		for (Detail detail : order.getDetails()) {
            detailsDTO.add(detailToDetailDTO(detail));
		}
		
		orderDTO.setDetails(detailsDTO);
		
		return orderDTO;
	}
	/**
	 * Maps a {@link OrderDTO} to a {@link Order}.
	 *
	 * @param orderDTO the order DTO to be mapped
	 * @return the mapped order
	 */
	public static Order orderDTOToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		Set<Detail> details = new HashSet<>();
		order.setOrder_id(orderDTO.getOrder_id());
		order.setFecha(orderDTO.getFecha());
		order.setTotal_pay(orderDTO.getTotal_pay());
		order.setClient(orderDTO.getClient());
		order.setPaid(orderDTO.isPaid());
		
		for (DetailDTO detailDTO : orderDTO.getDetails()) {
			details.add(detailDTOToDetail(detailDTO));
		}
		
		order.setDetails(details);
		
		return order;
	}
	/**
	 * Maps a {@link Product} to a {@link ProductDTO}.
	 *
	 * @param product the product to be mapped
	 * @return the mapped product
	 */
	public static ProductDTO productToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		Set<DetailDTO> detailsDTO = new HashSet<>();
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
	/**
	 * Maps a {@link ProductDTO} to a {@link Product}.
	 *
	 * @param productDTO the product DTO to be mapped
	 * @return the mapped product
	 */
	public static Product productDTOToProduct(ProductDTO productDTO) {
		Product product = new Product();
		Set<Detail> details = new HashSet<>();
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
