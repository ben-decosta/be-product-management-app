package org.product_management.productmanagementapp.repository;

import java.util.List;

import org.product_management.productmanagementapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByStatus(String status);
}
