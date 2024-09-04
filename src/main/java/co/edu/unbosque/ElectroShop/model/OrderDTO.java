package co.edu.unbosque.ElectroShop.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	private Long order_id;
	@NotBlank(message = "El pago total esta vacio!")
	private int total_pay;
	private boolean paid;
	private LocalDate fecha;
	@JsonBackReference
	private Client client;
	@JsonManagedReference
	private Set<DetailDTO> details;
	
	
	
	public OrderDTO() {

	}
	

	public OrderDTO(int total_pay, LocalDate fecha, boolean paid) {
		super();
		this.total_pay = total_pay;
		this.fecha = fecha;
		this.paid = paid;
	}





	
}
