package com.zepnds.pos_system.branch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_branch")
public class Branch {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String company_code;
    private String branch_address;
    private String branch_email;
}
