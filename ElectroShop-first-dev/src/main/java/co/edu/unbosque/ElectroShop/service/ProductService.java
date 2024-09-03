package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Product;
import co.edu.unbosque.ElectroShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {

    }

    /**
     * Saves a product to the product repository.
     *
     * @param  product  the product to be saved
     * @return           true if the product is saved successfully, false otherwise
     */
    public boolean saveProduct(Product product) {
        try {
            productRepository.save(product);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Retrieves a product from the product repository by its ID.
     *
     * @param  id  the ID of the product to be retrieved
     * @return     the product with the specified ID, or null if not found
     */
    public Product getProduct(long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Deletes a product from the product repository by its ID.
     *
     * @param  id  the ID of the product to be deleted
     * @return     true if the product is deleted successfully, false otherwise
     */
    public boolean deleteProduct(long id) {
        try {
            productRepository.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Updates a product in the product repository.
     *
     * @param  product  the product to be updated
     * @return          true if the product is updated successfully, false otherwise
     */
    public boolean updateProduct(Product product) {
        try {
            productRepository.save(product);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Saves multiple products to the product repository.
     *
     * @param  products  the list of products to be saved
     * @return          true if all products are saved successfully, false otherwise
     */
    public boolean saveAll(List<Product> products) {
        try {
            productRepository.saveAll(products);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

}
