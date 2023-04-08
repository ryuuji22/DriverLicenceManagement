package com.mitocode.licensewriteservice.domain.enums;

public enum CategoriaType {
	A("A"), 
	B("B"),
	F("F"), 
	A1("A1"),
	C("C"), 
	C1("C1"),
	D("D"), 
	D1("D1"),
	E("E"), 
	E1("E1"),
	G("G");

	String categoria;

	CategoriaType(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
		
	}

}
