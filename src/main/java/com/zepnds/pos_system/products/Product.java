package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "branch_code")
    private Integer branchCode;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers = new ArrayList<>();
}
