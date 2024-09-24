package com.zepnds.pos_system.products.converter;

import com.zepnds.pos_system.products.Product;
import com.zepnds.pos_system.products.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product convertDtotoEntity(ProductDto productDto){

        return Product
                .builder()
                .barcode(productDto.getBarcode())
                .branchCode(productDto.getBranchCode())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .sku(productDto.getSku())
                .quantity_in_stock(productDto.getQuantity_in_stock())
                .suppliers(productDto.getSupplier())
                .categories(productDto.getCategory())
                .is_active(productDto.getIs_active())
                .build();
    }

    public ProductDto convertProducttoDto(Product product){
        ProductDto productDto =  new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setBarcode(product.getBarcode());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategories());
        productDto.setPrice(product.getPrice());
        productDto.setIs_active(product.getIs_active());
        productDto.setSupplier(product.getSuppliers());
        productDto.setSku(product.getSku());
        productDto.setBranchCode(product.getBranchCode());
        productDto.setQuantity_in_stock(product.getQuantity_in_stock());
        return  productDto;
    }
}
