package com.zepnds.pos_system.products;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("C")
@Table(name = "_product_category")
public class Category extends Product {
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
