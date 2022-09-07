package com.example.project.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1), 
	PAID(2),
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);
	
	private int code;
	
	private OrderStatus (int code) { //Em caso de construtores em Enums, eles precisam ser private
		this.code = code;
	}
	
	public int getCode() { //Neste caso criamos um método público de acesso ao código
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid orderStatus code");
	}
}
