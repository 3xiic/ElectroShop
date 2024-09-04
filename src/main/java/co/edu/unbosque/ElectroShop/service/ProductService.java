package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Product;
import co.edu.unbosque.ElectroShop.model.ProductDTO;
import co.edu.unbosque.ElectroShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * @param  productDTO  the product to be saved
     * @return           true if the product is saved successfully, false otherwise
     */
    public boolean saveProduct(ProductDTO productDTO) {
        try {
            productRepository.save(DataMapper.productDTOToProduct(productDTO));
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
    @Cacheable(value = "productCache", key = "#id")
    public ProductDTO getProduct(long id) {
        if (productRepository.findById(id).isPresent()) {
            return DataMapper.productToProductDTO(productRepository.findById(id).get());
        }
        return null;
    }



    /**
     * Saves multiple products to the product repository.
     *
     * @param  products  the list of products to be saved
     * @return          true if all products are saved successfully, false otherwise
     */
    public boolean saveAll(List<ProductDTO> products) {
        try {
            for (ProductDTO productDTO : products) {
				productRepository.save(DataMapper.productDTOToProduct(productDTO));
			}
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Retrieves all products from the product repository.
     *
     * @return a list of all products in the database
     */
    public List<ProductDTO> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            productDTOList.add(DataMapper.productToProductDTO(product));
        }
        return productDTOList;
    }

    /**
     * Updates the stock of a product by the given amount.
     *
     * @param product the product to be updated
     * @param amount the amount to be subtracted from the product's stock
     */
    public void updateStock(ProductDTO product, int amount) {
        product.setStock(product.getStock() - amount);
        productRepository.save(DataMapper.productDTOToProduct(product));

    }
}
