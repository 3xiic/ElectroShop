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


	/**
	 * @return the order_id
	 */
	public Long getOrder_id() {
		return order_id;
	}


	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}


	/**
	 * @return the total_pay
	 */
	public int getTotal_pay() {
		return total_pay;
	}


	/**
	 * @param total_pay the total_pay to set
	 */
	public void setTotal_pay(int total_pay) {
		this.total_pay = total_pay;
	}


	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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



	
}
