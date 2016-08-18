package com.capinterview.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * Unit test for ThreeForTwoOffer
 * 
 * @author dipuchakrapani
 *
 */
public class ThreeForTwoOfferTest {
	
	@Test
	public void processOffer(){
		Item item = new ShoppingCartItem(5, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		OfferType offerType = new ThreeForTwoOffer();
		BigDecimal price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(4)), price);
		// 4items
		item = new ShoppingCartItem(4, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(3)), price);
		// 2items
		item = new ShoppingCartItem(2, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(2)), price);
		// 3items
		item = new ShoppingCartItem(3, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(2)), price);
		
		// 6items
		item = new ShoppingCartItem(6, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		price = offerType.processOffer(item);
		assertEquals(BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(4)), price);
		
		
	}

}
