package com.zepnds.pos_system.products.converter;

import com.zepnds.pos_system.products.Category;
import com.zepnds.pos_system.products.ProductCategoryDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryConverter {
    public Category convertDtoToEntity(ProductCategoryDto productCategoryDto){
        return Category
                .builder()
                .category_name(productCategoryDto.getCategory_name())
                .branchCode(productCategoryDto.getBranchCode())
                .build();
    }
    public ProductCategoryDto convertCategoryToDto(Category category){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setCategory_name(category.getCategory_name());
        productCategoryDto.setBranchCode(category.getBranchCode());
        productCategoryDto.setId(category.getId());
        return productCategoryDto;
    }

}
