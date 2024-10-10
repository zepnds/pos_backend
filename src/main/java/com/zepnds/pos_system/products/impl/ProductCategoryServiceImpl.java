package com.zepnds.pos_system.products.impl;

import com.zepnds.pos_system.merchant.MerchantErrorException;
import com.zepnds.pos_system.products.*;
import com.zepnds.pos_system.products.converter.CategoryConverter;
import com.zepnds.pos_system.products.exception.ProductErrorCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public ProductCategoryDto saveCategory(ProductCategoryDto productCategoryDto){
        try{
            if(categoryRepository.existsByCategoryNameAndBranchCode(productCategoryDto.getCategory_name(), productCategoryDto.getBranchCode())){
                throw new ProductErrorCreateException("Category " + productCategoryDto.getCategory_name() + " is already exist");
            }
            Category newcategory = categoryConverter.convertDtoToEntity(productCategoryDto);
            newcategory = categoryRepository.save(newcategory);
            productCategoryDto = categoryConverter.convertCategoryToDto(newcategory);
            return productCategoryDto;
        }catch (Exception e) {
            throw new ProductErrorCreateException("Failed to create due to the " + e.getMessage());
        }
    }

    @Override
    public List<ProductCategoryDto> findAllCategories(Integer branchCode){



        List<Category> categories = categoryRepository.findAllCategoriesByBranchCode(branchCode);

        return categories.stream().map(category -> {
            ProductCategoryDto dto = new ProductCategoryDto();
            dto.setBranchCode(category.getBranchCode());
            dto.setId(category.getId());
            dto.setCategory_name(category.getCategory_name());
            return dto;
        }).collect(Collectors.toList());

    }
    @Override
    public String deleteCategory(Integer id){
        if(id == null){
            throw  new MerchantErrorException("Category id is required");
        }

        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new MerchantErrorException("Category cannot be found");
        }

        categoryRepository.deleteCategory(id);

        return "Successfully delete";
    }
    @Override
    public ProductCategoryDto updateCategory(ProductCategoryDto productCategoryDto){


        if(productCategoryDto.getId() == null){
            throw new MerchantErrorException("Category id is required");
        }
        Optional<Category> category = categoryRepository.findById(productCategoryDto.getId());

        if(category.isEmpty()){
            throw new MerchantErrorException("Category cannot be found");
        }

        Category updatedCategory = updateProductAndReturnCategory(productCategoryDto.getCategory_name(), productCategoryDto.getBranchCode(), productCategoryDto.getId());

        updatedCategory.setCategory_name(productCategoryDto.getCategory_name());
        updatedCategory.setBranchCode(productCategoryDto.getBranchCode());

        return categoryConverter.convertCategoryToDto(updatedCategory);
    }

    public Category updateProductAndReturnCategory(String categoryName, Integer branchCode, Integer id) {
        categoryRepository.updateCategoryAndGetCategoryId(categoryName, branchCode, id);
        return categoryRepository.findCategoryById(id);
    }

}


