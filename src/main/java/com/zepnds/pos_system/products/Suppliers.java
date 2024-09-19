package com.zepnds.pos_system.products;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("S")
@Table(name = "_product_supplier")
public class Suppliers extends Product {
    private Integer id;
    @Column(nullable = false)
    private String supplier_name;
    private String contact_info;
    @Column(updatable = false , nullable = false)
    private LocalDateTime created_at;
    @Column(insertable = false)
    private LocalDateTime updated_at;
}
