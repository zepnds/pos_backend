package com.zepnds.pos_system.products;

import java.util.List;

public interface ProductService {
     ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> findAllProducts(Integer branchCode);
}
