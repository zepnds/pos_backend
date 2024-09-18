package com.zepnds.pos_system.branch;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BranchCreateRequest {
    private Integer id;
    private Integer company_code;
    private String branch_address;
    private String branch_email;
    private String branch_name;
}
