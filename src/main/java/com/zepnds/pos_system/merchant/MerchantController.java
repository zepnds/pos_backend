package com.zepnds.pos_system.merchant;
import com.zepnds.pos_system.book.Book;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MERCHANT')")
public class MerchantController {

    private final MerchantService service;

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('merchant:create')")
    @Hidden
    public ResponseEntity<MerchantResponse> register(
            @RequestBody MerchantRequest request
    ) {
        return ResponseEntity.ok(service.createMerchant(request));
    }
    @PreAuthorize("hasAuthority('merchant:create')")
    @GetMapping("/all")
    public ResponseEntity<MerchantResponse> findAllMerchant() {
        return ResponseEntity.ok(service.findAll());
    }


}
