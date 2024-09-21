package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Suppliers {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String supplier_name;
    private String contact_info;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
