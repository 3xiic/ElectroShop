package co.edu.unbosque.ElectroShop.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDTO {

	private Long client_id;
	private String client_name;
	private String client_lastname;
	private String address;
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

}
