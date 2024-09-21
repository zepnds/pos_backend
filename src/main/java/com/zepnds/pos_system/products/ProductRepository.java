package com.zepnds.pos_system.products;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("update Product a set a.name = :name where a.id =:id")
    int updateProduct(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    List<Product> findByNamedQuery(@Param("price") Integer price);

    @Modifying
    @Transactional
    @Query("update Product a set a.name = :age where a.id =:id")
    void updateByNamedQuery(@Param("name") String name, @Param("id") Integer id);
}
