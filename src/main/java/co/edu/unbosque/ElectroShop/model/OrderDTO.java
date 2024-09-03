package co.edu.unbosque.ElectroShop.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	private Long order_id;
	private int total_pay;
	private LocalDate fecha;
	@JsonBackReference
	private Client client;
	@JsonManagedReference
	private Set<DetailDTO> details;
	
	
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public OrderDTO(Long order_id, int total_pay, LocalDate fecha, Client client, Set<DetailDTO> details) {
		super();
		this.order_id = order_id;
		this.total_pay = total_pay;
		this.fecha = fecha;
		this.client = client;
		this.details = details;
	}



	
}
