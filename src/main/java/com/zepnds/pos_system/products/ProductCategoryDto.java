package com.zepnds.pos_system.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCategoryDto {
    private Integer id;
    private String categoryName;
    private Integer companyCode;
}
