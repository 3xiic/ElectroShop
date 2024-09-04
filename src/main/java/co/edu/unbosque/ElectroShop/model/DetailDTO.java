package co.edu.unbosque.ElectroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailDTO {

	private Long details_id;
	@NotBlank(message = "El monto esta vacio!")
	private int amount;
	
	@JsonBackReference
	private Order order;
	@JsonBackReference
	private Product product;
	
	public DetailDTO() {
		// TODO Auto-generated constructor stub
	}
	public DetailDTO(Long details_id, int amount, Order order, Product product) {
		super();
		this.details_id = details_id;
		this.amount = amount;
		this.order = order;
		this.product = product;
	}


	
}
