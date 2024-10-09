package com.zepnds.pos_system.products;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("update Product a set a.name = :name where a.id =:id")
    int updateProduct(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    @Query("select a from Product a where a.branchCode =:branchCode")
    List<Product> findAllProductsByBranchCode(@Param("branchCode") Integer branchCode);


    @Modifying
    @Transactional
    @Query("update Product a set a.name = :name where a.id =:id")
    void updateByNamedQuery(@Param("name") String name, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("delete from Product a where a.id = :id")
    int deleteProduct(@Param("id") Integer id);

    @Query("SELECT a FROM Product a WHERE a.id = :id")
    Optional<Product> findById(@Param("id") Integer id);

}

