package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

	private Long category_id;
	private String category_name;
	private String category_description;
	@JsonManagedReference
	private Set<ProductDTO> products;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Long category_id, String category_name, String category_description, Set<ProductDTO> products) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
		this.products = products;
	}

	
	
}
