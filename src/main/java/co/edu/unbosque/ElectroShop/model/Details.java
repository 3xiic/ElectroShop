package co.edu.unbosque.ElectroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="details")

public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long details_id;
	private int amount;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order order;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;
	
	
	public Details() {
		
	}
	
	public Details(Long details_id, int amount) {
		super();
		this.details_id = details_id;
		this.amount = amount;
	}


	public Long getDetails_id() {
		return details_id;
	}
	public void setDetails_id(Long details_id) {
		this.details_id = details_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
