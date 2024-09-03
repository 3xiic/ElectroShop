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
}
