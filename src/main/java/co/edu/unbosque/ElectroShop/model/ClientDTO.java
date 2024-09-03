package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDTO {

	private Long client_id;
	@NotBlank(message = "El nombre esta vacio!")
	private String client_name;
	@NotBlank(message = "El apellido esta vacio!")
	private String client_lastname;
	@NotBlank(message = "La direccion esta vacia!")
	private String address;
	@NotBlank(message = "El telefono esta vacio!")
	private String phone_number;
	@JsonManagedReference
	private Set<OrderDTO> orders;
	
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClientDTO(Long client_id, String client_name, String client_lastname, String address, String phone_number,
			Set<OrderDTO> orders) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
		this.client_lastname = client_lastname;
		this.address = address;
		this.phone_number = phone_number;
		this.orders = orders;
	}

	/**
	 * @return the client_id
	 */
	public Long getClient_id() {
		return client_id;
	}

	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	/**
	 * @return the client_name
	 */
	public String getClient_name() {
		return client_name;
	}

	/**
	 * @param client_name the client_name to set
	 */
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	/**
	 * @return the client_lastname
	 */
	public String getClient_lastname() {
		return client_lastname;
	}

	/**
	 * @param client_lastname the client_lastname to set
	 */
	public void setClient_lastname(String client_lastname) {
		this.client_lastname = client_lastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the orders
	 */
	public Set<OrderDTO> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<OrderDTO> orders) {
		this.orders = orders;
	}

	
}
