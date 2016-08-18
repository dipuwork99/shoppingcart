package com.capinterview.shoppingcart;

import java.math.BigDecimal;

/**
 * Concrete implemenations of offers should implement this class
 * 
 * @author dipuchakrapani
 *
 */
public interface OfferType {

	public BigDecimal processOffer(Item item);
}
