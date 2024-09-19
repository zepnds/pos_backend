package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_product_category")
public class Category {
    @GeneratedValue
    @Id
    private Integer id;
    @Column(nullable = false)
    private String category_name;
    @Column(updatable = false , nullable = false)
    private LocalDateTime created_at;
    @Column(insertable = false)
    private LocalDateTime updated_at;
}
