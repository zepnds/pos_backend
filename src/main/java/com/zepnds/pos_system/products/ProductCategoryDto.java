package com.zepnds.pos_system.products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryDto {
    private Integer id;
    private String category_name;
    private Integer branchCode;
}
