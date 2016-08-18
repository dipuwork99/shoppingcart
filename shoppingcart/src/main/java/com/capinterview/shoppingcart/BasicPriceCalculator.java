package com.capinterview.shoppingcart;

import java.math.BigDecimal;


/**
 * Does Basic price calculation for an item.
 * 
 * @author dipuchakrapani
 *
 */
public class BasicPriceCalculator implements PriceCalculator {

	@Override
	public BigDecimal calculatePrice( Item item) {

		return item.getPrice().multiply(new BigDecimal(item.getQuantity()));
	}
	
}
