package com.zepnds.pos_system.merchant;

import com.zepnds.pos_system.book.Book;
import com.zepnds.pos_system.user.ChangePasswordRequest;
import com.zepnds.pos_system.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository repository;

    public MerchantResponse createMerchant(MerchantRequest request) {
        if (repository.existsByEmail(request.getMerchant_email())) {
            throw new MerchantErrorException("Business email " + request.getMerchant_email() + " already registered");
        }
        var merchant = Merchant.builder()
                .name(request.getName())
                .address(request.getMerchant_address())
                .email(request.getMerchant_email())
                .type(request.getMerchant_type())
                .build();
        repository.save(merchant);
       return MerchantResponse.builder().message("Business name " + request.getName() + " Successfully added").status(HttpStatus.CREATED).build();
    }
    public MerchantResponse findAllMerchant( Integer createdBy) {

        log.info(String.valueOf(createdBy));
        List<Merchant> merchants = repository.findByCreatedBy(createdBy);
        if(merchants.isEmpty()){
            return MerchantResponse.builder().status(HttpStatus.NOT_FOUND).message("Business List is empty").merchants(new ArrayList<>()).build();
        }else{
            return MerchantResponse.builder().status(HttpStatus.OK).merchants(merchants).message("Success retrieving business list").build();
        }
    }


    public MerchantDeleteResponse deleteMerchant(Integer id){
        if(id == null){
            throw new MerchantErrorException("Please provide and id");
        }

          repository.deleteById(id);
          return MerchantDeleteResponse.builder().message("Successfully deleted ").status(HttpStatus.OK).build();
    }

    public  MerchantUpdateResponse updateMerchant(Integer id, MerchantRequest request){
        if(request.getName() == null){
            throw new MerchantErrorException("Please provide the business name");
        }
        if(request.getMerchant_email() == null){
            throw new MerchantErrorException("Please provide the business email");
        }

        if(request.getMerchant_address() == null){
            throw new MerchantErrorException("Please provide the business address");
        }

        if(request.getMerchant_type() == null){
            throw new MerchantErrorException("Please provide the business type");
        }

        Merchant merchant = repository.findById(request.getId())
                .orElseThrow(() -> new MerchantErrorException("Merchant with ID " + id + " not found"));

        merchant.setAddress(request.getMerchant_address());
        merchant.setEmail(request.getMerchant_email());
        merchant.setType(request.getMerchant_type());
        merchant.setName(request.getName());

        repository.save(merchant);

        return MerchantUpdateResponse.builder()
                .message("Merchant with the name " + request.getName() + " successfully updated")
                .status(HttpStatus.OK)
                .build();
    }
}
