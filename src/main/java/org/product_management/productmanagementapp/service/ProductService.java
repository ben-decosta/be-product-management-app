package org.product_management.productmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.product_management.productmanagementapp.model.Product;
import org.product_management.productmanagementapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        product.setStatus("pending");
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        product.setStatus("pending");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByStatus(String status) {
        return productRepository.findByStatus(status);
    }

    public List<Product> getPendingProducts() {
        return productRepository.findByStatus("pending");
    }

    public Product updateApprovedProduct(Long id) {
        String new_status = "approved";
        Optional<Product> getProduct = productRepository.findById(id);

        if (getProduct.isPresent()) {
            Product product = getProduct.get();
            product.setStatus(new_status);
            return productRepository.save(product);
        }
        return null;
    }

    public Product updateRejectedProduct(Long id) {
        String new_status = "rejected";
        Optional<Product> getProduct = productRepository.findById(id);

        if (getProduct.isPresent()) {
            Product product = getProduct.get();
            product.setStatus(new_status);
            return productRepository.save(product);
        }
        return null;
    }
}
