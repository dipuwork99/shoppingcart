package com.capinterview.shoppingcart;

import java.math.BigDecimal;

/**
 * Represents a shoppingcartitem
 * 
 * @author dipuchakrapani
 *
 */
public class ShoppingCartItem implements Item{

	private int quantity;
	
	private BigDecimal price;
	
	private String code;
	
	public ShoppingCartItem(int quanity , BigDecimal price , String code){
		this.quantity = quanity;
		this.price = price;
		this.code = code;
		if(price == null || code ==  null || code.length() == 0){
			throw new InvalidConfiguration(BasicReferenceDataRetreiver.ERRORMESSAGE);
		}
	}
	
	@Override
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	
	public String getCode() {
		return code;
	}

	
	
}
