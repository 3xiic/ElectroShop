package co.edu.unbosque.ElectroShop.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Orders")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	private int total_pay;
	private LocalDate fecha;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<Detail> details;

	public Order() {

	}

	public Order(int total_pay, LocalDate fecha) {
		super();
		this.total_pay = total_pay;
		this.fecha = fecha;
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
	public Set<Detail> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(Set<Detail> details) {
		this.details = details;
	}
	
	
	
}
