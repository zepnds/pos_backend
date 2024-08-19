package com.zepnds.pos_system.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
    MERCHANT_READ("merchant:read"),
    MERCHANT_UPDATE("merchant:update"),
    MERCHANT_CREATE("merchant:create"),
    MERCHANT_DELETE("merchant:delete");

    ;

    @Getter
    private final String permission;
}
