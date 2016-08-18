package com.capinterview.shoppingcart;

import java.math.BigDecimal;


/**
 * Represents a shopping item
 * 
 * @author dipuchakrapani
 *
 */
public interface Item {
	
	
	public BigDecimal getPrice();
	
	public int getQuantity() ;
		
	public String getCode() ;


}
