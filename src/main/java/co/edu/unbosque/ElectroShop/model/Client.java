package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Clients")
@Getter
@Setter
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long client_id;
	private String client_name;
	private String client_lastname;
	private String address;
	private String phone_number;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Order> orders;

	
	public Client(String client_name, String client_lastname, String address, String phone_number) {
		super();
		this.client_name = client_name;
		this.client_lastname = client_lastname;
		this.address = address;
		this.phone_number = phone_number;
		
	}
	public Client() {

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
	public Set<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
