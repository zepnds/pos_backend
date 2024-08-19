package com.zepnds.pos_system.merchant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MerchantRequest {
    private Integer id;
    private String name;
    private String merchant_address;
    private String merchant_type;
    private String merchant_email;
}
