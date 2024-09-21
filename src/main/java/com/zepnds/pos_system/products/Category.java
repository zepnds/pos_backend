package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Category  {
    @GeneratedValue
    @Id
    private Integer id;
    @Column(nullable = false)
    private String category_name;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
