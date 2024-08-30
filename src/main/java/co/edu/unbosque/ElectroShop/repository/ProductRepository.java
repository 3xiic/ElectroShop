package co.edu.unbosque.ElectroShop.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.ElectroShop.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
