package com.aksh.management.service;
import com.aksh.management.model.Product;
import com.aksh.management.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        List<Product> listofProducts = productRepository.findAll();
        for (Product product : listofProducts) {
            System.out.println(product);
           // product.setDescription(product.getDescription()+" Akshaya");
        }
        return listofProducts;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
