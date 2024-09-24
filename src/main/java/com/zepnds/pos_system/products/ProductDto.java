package com.zepnds.pos_system.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private Integer id;
    private String name;
    private Long price;
    private String sku;
    private String description;
    private Long quantity_in_stock;
    private Integer branchCode;
    private String barcode;
    private List<Category> category;
    private List<Supplier> supplier;
    private Boolean is_active;
    private List<String> categoryList;
    private List<String> supplierList;
}
