package com.book.demo.Book;

import org.springframework.stereotype.Component;

@Component
public class CheckOutResponse {
public Double totalprice;

public Double getTotalprice() {
	return totalprice;
}

public void setTotalprice(Double totalprice) {
	this.totalprice = totalprice;
}

}
