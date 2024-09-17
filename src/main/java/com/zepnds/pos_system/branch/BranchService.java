package com.zepnds.pos_system.branch;

import com.zepnds.pos_system.merchant.Merchant;
import com.zepnds.pos_system.merchant.MerchantErrorException;
import com.zepnds.pos_system.merchant.MerchantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository repository;



    public BranchCreateResponse register(BranchCreateRequest request){

        if (repository.existsByName(request.getBranch_name())) {
            throw new BranchErrorException("Branch name " + request.getBranch_name() + " already registered");
        }

        if(request.getBranch_name() == null){
            throw new BranchErrorException("Branch name is required");
        }

        if(request.getBranch_address() == null){
            throw  new BranchErrorException("Branch address is required");
        }

        if(request.getCompany_code() == null){
            throw new BranchErrorException("Company code is required");
        }

        if(request.getBranch_email() == null){
            throw new BranchErrorException("Branch email is required");
        }


          var branch = Branch.builder()
                  .address(request.getBranch_address())
                  .email(request.getBranch_email())
                  .code(request.getCompany_code())
                  .name(request.getBranch_name())
                  .build();

        repository.save(branch);

        return BranchCreateResponse.builder().message("Successfully added " + request.getBranch_name()).status(HttpStatus.OK).build();
    }

    public BranchResponse findAllBranches(Integer id) {

        List<Branch> branches = repository.findAllByCode(id);
        if(branches.isEmpty()){
            return BranchResponse.builder().status(HttpStatus.NOT_FOUND).message("Business List is empty").branches(new ArrayList<>()).build();
        }else{
            return BranchResponse.builder().status(HttpStatus.OK).branches(branches).message("Success retrieving business list").build();
        }
    }
}
