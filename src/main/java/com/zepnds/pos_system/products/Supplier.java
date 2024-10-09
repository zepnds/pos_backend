package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer companyCode;
    private String supplier_name;
    private String contact_info;

@ManyToMany(mappedBy = "suppliers", fetch = FetchType.LAZY)
private List<Product> products = new ArrayList<>();
}
