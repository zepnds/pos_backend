package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance
@NamedQueries({
        @NamedQuery(name = "Product.findByNamedQuery", query = "select a from Product a where a.price >= :price"),
        @NamedQuery(name = "Product.updateByNamedQuery", query = "update Product a set a.price = :price where a.id =:id")
})

public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "product_name",nullable = true)
    private String name;
    @Column(name = "product_price",nullable = true)
    private Long price;
    @Column( unique = true,nullable = true)
    private String barcode;
    @Column( nullable = true)
    private String sku;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private Long quantity_in_stock;
    @Column(nullable = true)
    private Boolean is_active;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private  Suppliers supplier;
}
