package com.capinterview.shoppingcart;

import java.math.BigDecimal;
/**
 *Two for one offer
 * 
 * @author dipuchakrapani
 *
 */
public class TwoForOneOffer implements OfferType{

	@Override
	public BigDecimal processOffer(Item item) {
		
		double fraction = 1.0/2.0;
		double amount = item.getQuantity()*(fraction);
	    double quantity = Math.ceil(amount);
		return item.getPrice().multiply(new BigDecimal(quantity));
	}

}
