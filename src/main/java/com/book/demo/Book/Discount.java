package com.book.demo.Book;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Discount {
private String type;
private Double discount;
private int quantity;

public Discount(String type, Double discount, int quantity) {

	this.type = type;
	this.discount = discount;
	this.quantity = quantity;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Double getDiscount() {
	return discount;
}
public void setDiscount(Double discount) {
	this.discount = discount;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
