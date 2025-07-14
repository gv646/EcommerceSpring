package org.example.ecommercespring.repository;

import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p where p.price>:minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    @Query(value="Select * FROM product where MATCH(name,description) AGAINST (:keyword)",nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);
}
