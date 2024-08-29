package com.zepnds.pos_system.merchant;

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
@CrossOrigin
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
    public ResponseEntity<MerchantResponse> findAllMerchant(@RequestParam Integer createdBy) {

        return ResponseEntity.ok(service.findAllMerchant(createdBy));
    }
    @PreAuthorize("hasAuthority('merchant:delete')")
    @DeleteMapping("/delete")
    public ResponseEntity<MerchantDeleteResponse> deleteMerchant(@RequestParam Integer id) {

        return ResponseEntity.ok(service.deleteMerchant(id));
    }
    @PreAuthorize("hasAuthority('merchant:delete')")
    @PutMapping("/update")
    public ResponseEntity<MerchantUpdateResponse> updateMerchant(@RequestParam Integer id, @RequestBody MerchantRequest request){
        return ResponseEntity.ok(service.updateMerchant(id, request));
    }
}
