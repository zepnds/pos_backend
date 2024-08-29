package com.zepnds.pos_system.branch;

import com.zepnds.pos_system.merchant.MerchantErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository repository;



    public BranchCreateResponse register(BranchCreateRequest request){

        if (repository.existsByName(request.getName())) {
            throw new BranchErrorException("Branch name " + request.getName() + " already registered");
        }

        if(request.getName() == null){
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
                  .branch_address(request.getBranch_address())
                  .branch_email(request.getBranch_email())
                  .company_code(request.getCompany_code())
                  .name(request.getName())
                  .company_code(request.getCompany_code())
                  .build();

        repository.save(branch);

        return BranchCreateResponse.builder().message("Successfully added " + request.getName()).status(HttpStatus.OK).build();
    }
}
