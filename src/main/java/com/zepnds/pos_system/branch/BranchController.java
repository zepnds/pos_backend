package com.zepnds.pos_system.branch;


import com.zepnds.pos_system.merchant.MerchantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MERCHANT')")
@CrossOrigin
public class BranchController {
    private final BranchService service;

    @PostMapping("/register")
    public ResponseEntity<BranchCreateResponse> register(
            @RequestBody BranchCreateRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PreAuthorize("hasAuthority('merchant:read')")
    @GetMapping("/all")
    public ResponseEntity<BranchResponse> findAllBranch(@RequestParam Integer id) {
        return ResponseEntity.ok(service.findAllBranches(id));
    }
}
