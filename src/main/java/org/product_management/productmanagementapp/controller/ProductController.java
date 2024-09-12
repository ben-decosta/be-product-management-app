package org.product_management.productmanagementapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.product_management.productmanagementapp.model.Product;
import org.product_management.productmanagementapp.response.ResponseResult;
import org.product_management.productmanagementapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ResponseResult<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();

        ResponseResult<Product> response = new ResponseResult<>(200, "success", products);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity<ResponseResult<String>> addProduct(@Valid @RequestBody Product product) {
        Product addProduct = productService.addProduct(product);

        ResponseResult<String> response = new ResponseResult<>(200, "successfully added product", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseResult<Optional>> getProductById(@PathVariable("id") Long id) {
        Optional optional = productService.getProductById(id);
        if (optional.isPresent()) {
            List<Optional> products = Arrays.asList(optional);

            ResponseResult<Optional> response = new ResponseResult<>(200, "success", products);
            return ResponseEntity.ok(response);
        } else {
            ResponseResult<Optional> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ResponseResult<String>> updateProduct(@Valid @PathVariable Long id, @RequestBody Product product) {
        if (productService.getProductById(id).isPresent()) {
            Product addProduct = productService.updateProduct(id, product);

            ResponseResult<String> response = new ResponseResult<>(200, "successfully updated product", null);
            return ResponseEntity.ok(response);
        } else {
            ResponseResult<String> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseResult<Optional>> deleteProductById(@PathVariable("id") Long id) {
        Optional optional = productService.getProductById(id);
        if (optional.isPresent()) {
            productService.deleteProduct(id);
            ResponseResult<Optional> response = new ResponseResult<>(200, "successfully deleted product", null);
            return ResponseEntity.ok(response);
        } else {
            ResponseResult<Optional> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<ResponseResult<Product>> getAllApprovedProduct(@RequestParam String status) {
        List<Product> products = productService.getProductsByStatus(status);

        if (products.isEmpty()) {
            ResponseResult<Product> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            ResponseResult<Product> response = new ResponseResult<>(200, "success", products);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/products/pending")
    public ResponseEntity<ResponseResult<Product>> getAllPendingProduct() {
        List<Product> products = productService.getPendingProducts();

        ResponseResult<Product> response = new ResponseResult<>(200, "success", products);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}/approve")
    public ResponseEntity<ResponseResult<String>> updateApprovedProduct(@PathVariable Long id) {
        if (productService.getProductById(id).isPresent()) {
            Product approvedProduct = productService.updateApprovedProduct(id);

            ResponseResult<String> response = new ResponseResult<>(200, "successfully updated product", null);
            return ResponseEntity.ok(response);
        } else {
            ResponseResult<String> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/products/{id}/reject")
    public ResponseEntity<ResponseResult<String>> updateRejectedProduct(@PathVariable Long id) {
        if (productService.getProductById(id).isPresent()) {
            Product rejectedProduct = productService.updateRejectedProduct(id);

            ResponseResult<String> response = new ResponseResult<>(200, "successfully updated product", null);
            return ResponseEntity.ok(response);
        } else {
            ResponseResult<String> response = new ResponseResult<>(HttpStatus.NOT_FOUND.value(), "Product Not Found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
