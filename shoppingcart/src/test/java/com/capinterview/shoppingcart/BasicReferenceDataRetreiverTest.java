package com.capinterview.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BasicReferenceDataRetreiverTest {
	
	public static final String INVALIDITEM = "invaliditem";

	@Test
	public void getPriceByCode(){
		ReferenceDataRetriever referenceDataRetriever =  new BasicReferenceDataRetreiver();
		BigDecimal orangePrice = referenceDataRetriever.getPriceByCode(ItemEnum.Orange.toString());
		assertEquals(BasicReferenceDataRetreiver.OrangePrice, orangePrice);
		BigDecimal applePrice = referenceDataRetriever.getPriceByCode(ItemEnum.Apple.toString());
		assertEquals(BasicReferenceDataRetreiver.ApplePrice, applePrice);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getPriceByCodeIvalidItem(){
		ReferenceDataRetriever referenceDataRetriever =  new BasicReferenceDataRetreiver();
		BigDecimal nullPrice = referenceDataRetriever.getPriceByCode(INVALIDITEM);
		assertEquals(null, nullPrice);
	}
}
