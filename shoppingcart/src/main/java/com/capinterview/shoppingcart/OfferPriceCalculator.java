package com.capinterview.shoppingcart;

import java.math.BigDecimal;

/**
 * Price calculations when o fferes are in place
 * 
 * @author dipuchakrapani
 *
 */
public class OfferPriceCalculator implements PriceCalculator {
	
	private ReferenceDataRetriever referenceDataRetriever;
	public OfferPriceCalculator(ReferenceDataRetriever referenceDataRetriever)
	{
		this.referenceDataRetriever = referenceDataRetriever;
	}

	public BigDecimal calculatePrice(Item item) {
		OfferFactory factory = new OfferFactory(referenceDataRetriever);
	    OfferType offerType = factory.getOfferType(item.getCode());
	    return offerType.processOffer(item);
	}
	
}
