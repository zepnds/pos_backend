package com.zepnds.pos_system.merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    @Modifying
    @Query("DELETE FROM Merchant m WHERE m.id = :ids")
    void deleteById(@Param("ids") List<Integer> ids);


    List<Merchant> findByCreatedBy(Integer createdBy);
}
