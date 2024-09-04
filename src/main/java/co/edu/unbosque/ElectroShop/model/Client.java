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

}
