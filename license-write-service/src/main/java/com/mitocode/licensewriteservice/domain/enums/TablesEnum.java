package com.mitocode.licensewriteservice.domain.enums;

import lombok.Getter;

@Getter
public enum TablesEnum {

	LICENCIAS("LICENCIAS"),
	SOLICITANTES("SOLICITANTES");

	private final String table;

	TablesEnum(String table) {
		this.table = table;
	}

	public String getTable() {
		return table;
	}

}
