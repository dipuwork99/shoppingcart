package com.capinterview.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * Unit test for OfferPriceCalculator
 * 
 * @author dipuchakrapani
 *
 */
public class OfferPriceCalculatorTest {

	public static final String INVALIDITEM = "invaliditem";
	@Test
	public void calculatePrice(){
		Item item = new ShoppingCartItem(5, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		ReferenceDataRetriever referenceDataRetriever = new BasicReferenceDataRetreiver();
		PriceCalculator calculator = new OfferPriceCalculator(referenceDataRetriever);
		BigDecimal price = calculator.calculatePrice(item);
		assertEquals( BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(3)) , price);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculatePriceException(){
		Item item = new ShoppingCartItem(5, BasicReferenceDataRetreiver.OrangePrice,INVALIDITEM);
		ReferenceDataRetriever referenceDataRetriever = new BasicReferenceDataRetreiver();
		PriceCalculator calculator = new OfferPriceCalculator(referenceDataRetriever);
		calculator.calculatePrice(item);
	
	}
}
