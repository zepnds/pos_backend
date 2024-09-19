package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type")
@Table(name = "_product")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private Long price;
    @Column(nullable = false, unique = true)
    private String barcode;
    @Column(nullable = false, unique = true)
    private String sku;
    private String description;
    private Integer category_id;
    private Long quantity_in_stock;
    private Integer supplier_id;
    private Boolean is_active;
    @Column(updatable = false , nullable = false)
    private LocalDateTime created_at;
    @Column(insertable = false)
    private LocalDateTime updated_at;
}
