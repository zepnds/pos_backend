package com.zepnds.pos_system.products;
import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDto saveCategory(ProductCategoryDto productCategoryDto);
    List<ProductCategoryDto> findAllCategories(Integer branchCode);
    String deleteCategory(Integer id);
    ProductCategoryDto updateCategory(ProductCategoryDto productCategoryDto);
}
