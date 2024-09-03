package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private Long product_id; 
	private String product_name;
	private double price;
	private int stock;
	@JsonManagedReference
	private Set<DetailDTO> details;
	@JsonBackReference
	private Category category;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long product_id, String product_name, double price, int stock, Set<DetailDTO> details,
			Category category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.stock = stock;
		this.details = details;
		this.category = category;
	}

	/**
	 * @return the product_id
	 */
	public Long getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the details
	 */
	public Set<DetailDTO> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(Set<DetailDTO> details) {
		this.details = details;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
