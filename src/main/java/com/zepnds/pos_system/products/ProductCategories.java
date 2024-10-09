package com.zepnds.pos_system.products;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategories extends JpaRepository<Category, Integer> {
    @Transactional
    @Query("select a from Category a where a.branchCode =:branchCode")
    List<Category> findAllCategory();

}
