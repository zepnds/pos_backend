package com.zepnds.pos_system.merchant;

import com.zepnds.pos_system.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository repository;

    public MerchantResponse createMerchant(MerchantRequest request) {
        if (repository.existsByName(request.getName())) {
            throw new MerchantErrorException("Business name " + request.getName() + " already registered");
        }
        var merchant = Merchant.builder()
                .name(request.getName())
                .merchant_address(request.getMerchant_address())
                .merchant_email(request.getMerchant_email())
                .merchant_type(request.getMerchant_type())
                .build();
        repository.save(merchant);
       return MerchantResponse.builder().message("Business name " + request.getName() + " Successfully added").status(HttpStatus.CREATED).build();
    }
    public List<Merchant> findAll() {
        return repository.findAll();
    }
}
