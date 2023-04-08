package com.mitocode.licensewriteservice.domain.enums;

import lombok.Getter;

@Getter
public enum ActionsEnum {
	CREATE("CREATE"),
    DELETE("DELETE"),
    UPDATE("UPDATE")
    ;

    private final String action;

    ActionsEnum(String action) {
        this.action = action;
    }


}
