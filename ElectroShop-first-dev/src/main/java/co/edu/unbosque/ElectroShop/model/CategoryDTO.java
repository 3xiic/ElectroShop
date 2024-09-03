package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class CategoryDTO {

	private Long category_id;
	private String category_name;
	private String category_description;
	@JsonManagedReference
	private Set<ProductDTO> products;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param category_id
	 * @param category_name
	 * @param category_description
	 * @param products
	 */
	public CategoryDTO(Long category_id, String category_name, String category_description, Set<ProductDTO> products) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
		this.products = products;
	}

	/**
	 * @return the category_id
	 */
	public Long getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}

	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	/**
	 * @return the category_description
	 */
	public String getCategory_description() {
		return category_description;
	}

	/**
	 * @param category_description the category_description to set
	 */
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	/**
	 * @return the products
	 */
	public Set<ProductDTO> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}
	
	
	
}
