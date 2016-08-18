package com.capinterview.shoppingcart;

import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for TwoForOneOffer
 * 
 * @author dipuchakrapani
 *
 */
public class TwoForOneOfferTest {

	@Test
	public void processOffer(){
		Item item = new ShoppingCartItem(5, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		OfferType offerType = new TwoForOneOffer();
		BigDecimal price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(3)), price);
		item = new ShoppingCartItem(4, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(2)), price);
	}
}
