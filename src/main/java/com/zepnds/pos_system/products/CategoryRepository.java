package com.zepnds.pos_system.products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT COUNT(a) > 0 FROM Category a WHERE a.category_name = :categoryName AND a.branchCode = :branchCode")
    boolean existsByCategoryNameAndBranchCode(@Param("categoryName") String categoryName, @Param("branchCode") Integer branchCode);

    @Transactional
    @Query("select a from Category a where a.branchCode =:branchCode")
    List<Category> findAllCategoriesByBranchCode(@Param("branchCode") Integer branchCode);

    @Modifying
    @Transactional
    @Query("delete from Category a where a.id = :id")
    int deleteCategory(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Category p SET p.category_name = :category_name, p.branchCode = :branchCode WHERE p.id = :id")
    Integer updateCategoryAndGetCategoryId(@Param("category_name") String categoryName,
                                          @Param("branchCode") Integer branchCode,
                                          @Param("id") Integer id);

    @Transactional
    @Query("SELECT c FROM Category c WHERE c.id = :categoryId")
    Category findCategoryById(@Param("categoryId") Integer categoryId);
}
