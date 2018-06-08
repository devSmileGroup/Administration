package com.dev.booking.models;

public enum Role {
	
	ADMIN("ADMIN"),
	CLIENT("CLIENT"), 
	HOST("HOST");
	
	private String role;

    Role(String role) {
        this.role = role;
    }

    public String ToString() {
        return role;
    }
}
