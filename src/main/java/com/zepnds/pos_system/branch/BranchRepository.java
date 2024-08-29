package com.zepnds.pos_system.branch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository  extends JpaRepository<Branch, Integer> {
    boolean existsByName(String name);
}
