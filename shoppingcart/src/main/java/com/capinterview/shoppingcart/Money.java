package com.capinterview.shoppingcart;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Class that contains a price amount and the associated currency
 * 
 * @author dipuchakrapani
 *
 */
public class Money {

	private Currency currency;
	private BigDecimal price;

	public Money(Currency currency , BigDecimal amount){
		this.currency = currency;
		this.price = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
}
