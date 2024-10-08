package com.zepnds.pos_system.branch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository  extends JpaRepository<Branch, Integer> {
    boolean existsByName(String name);
    List<Branch> findAllByCode(Integer id);
}
