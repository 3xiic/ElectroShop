package co.edu.unbosque.ElectroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class DetailDTO {

	private Long details_id;
	private int amount;
	@JsonBackReference
	private Order order;
	@JsonBackReference
	private Product product;
	
	public DetailDTO() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param details_id
	 * @param amount
	 * @param order
	 * @param product
	 */
	public DetailDTO(Long details_id, int amount, Order order, Product product) {
		super();
		this.details_id = details_id;
		this.amount = amount;
		this.order = order;
		this.product = product;
	}

	/**
	 * @return the details_id
	 */
	public Long getDetails_id() {
		return details_id;
	}

	/**
	 * @param details_id the details_id to set
	 */
	public void setDetails_id(Long details_id) {
		this.details_id = details_id;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
