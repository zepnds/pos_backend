package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


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
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY) // Set to LAZY
    private List<Product> products = new ArrayList<>();

}
