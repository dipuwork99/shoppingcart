package com.capinterview.shoppingcart;

import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;

import org.junit.Test;

/**
 * Unit test for BasicPriceCalculator
 * @author dipuchakrapani
 *
 */
public class BasicPriceCalculatorTest {

	@Test
	public void calculatePrice(){
		Item item = new ShoppingCartItem(5, BasicReferenceDataRetreiver.OrangePrice,ItemEnum.Orange.toString());
		PriceCalculator calculator = new BasicPriceCalculator();
		BigDecimal price = calculator.calculatePrice(item);
		assertEquals(price , BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(5)));
	}

	@Test(expected = InvalidConfiguration.class)
	public void calculatePriceException(){
		Item item = new ShoppingCartItem(5, null,ItemEnum.Orange.toString());
		PriceCalculator calculator = new BasicPriceCalculator();
		BigDecimal price = calculator.calculatePrice(item);
		assertEquals(price , new BigDecimal("1.25"));
	}
}
