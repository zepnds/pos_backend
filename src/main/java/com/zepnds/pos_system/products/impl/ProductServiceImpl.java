package com.zepnds.pos_system.products.impl;

import com.zepnds.pos_system.products.*;
import com.zepnds.pos_system.products.converter.ProductConverter;
import com.zepnds.pos_system.products.exception.ProductErrorCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDto saveProduct(ProductDto productDto){
       try{
           Product newProduct =  productConverter.convertDtotoEntity(productDto);
           newProduct = productRepository.save(newProduct);
           productDto = productConverter.convertProducttoDto(newProduct);
           return productDto;
       } catch (Exception e){
            throw new ProductErrorCreateException("Failed to create due to the " + e.getMessage() );
       }

    }

    @Override
    public List<ProductDto> findAllProducts(Integer branchCode) {
        List<Product> products = productRepository.findAllProductsByBranchCode(branchCode);

        return products.stream().map(product -> {
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setSku(product.getSku());
            dto.setQuantity_in_stock(product.getQuantity_in_stock());
            dto.setIs_active(product.getIs_active());
            dto.setPrice(product.getPrice());
            dto.setBranchCode(product.getBranchCode());
            dto.setDescription(product.getDescription());
            dto.setBarcode(product.getBarcode());
            List<String> SupplierNames = product.getSuppliers().stream()
                    .map(Supplier::getSupplier_name)
                    .toList();
            List<String> categoryNames = product.getCategories().stream()
                    .map(Category::getCategory_name)
                    .toList();
            dto.setCategoryList(categoryNames);
            dto.setSupplierList(SupplierNames);
            return dto;
        }).collect(Collectors.toList());
    }


}
