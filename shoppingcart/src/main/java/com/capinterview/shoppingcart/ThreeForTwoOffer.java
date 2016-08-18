package com.capinterview.shoppingcart;

import java.math.BigDecimal;
/**
 *Three for Two offer
 * 
 * @author dipuchakrapani
 *
 */
public class ThreeForTwoOffer implements OfferType {

	@Override
	public BigDecimal processOffer(Item item) {
		double fraction = 2.0/3.0;
		double amount = item.getQuantity()*(fraction);
	    double quantity = Math.ceil(amount);
		return item.getPrice().multiply(new BigDecimal(quantity));
	}

}
