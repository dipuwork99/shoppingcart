package com.capinterview.shoppingcart;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

/**
 * Unit test for CheckOut
 * 
 * @author dipuchakrapani
 *
 */
public class CheckOutTest {

	ReferenceDataRetriever referenceDataRetriever = new BasicReferenceDataRetreiver();
	PriceCalculator priceCalculator = new BasicPriceCalculator();
	Locale localeUk = Locale.UK;
	String scannedItems[] = {"Orange","Orange","Apple"};

	
	@Test
	public void processShopping(){
		CheckOut checkOut = new CheckOut(referenceDataRetriever, priceCalculator, localeUk);
		Money totalPrice = checkOut.processShoping(scannedItems);
		assertEquals((BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(2))).add(BasicReferenceDataRetreiver.ApplePrice) ,totalPrice.getPrice());
	}
	
	@Test
	public void calcuateTotalPrice(){
		CheckOut checkOut = new CheckOut(referenceDataRetriever, priceCalculator, localeUk);
		Map<String, Integer> itemCounterMap = checkOut.getCountByItemType(scannedItems);
		List<ShoppingCartItem> shoppingCartItems = checkOut.updateShoppingCartWithPriceDetails(itemCounterMap);
		Money totalPrice = checkOut.calcuateTotalPrice(shoppingCartItems);
		assertEquals((BasicReferenceDataRetreiver.OrangePrice.multiply(new BigDecimal(2))).add(BasicReferenceDataRetreiver.ApplePrice) ,totalPrice.getPrice());
	} 
	
	@Test
	public void updateShoppingCartWithPriceDetails(){
		CheckOut checkOut = new CheckOut(referenceDataRetriever, priceCalculator, localeUk);
		Map<String, Integer> itemCounterMap = checkOut.getCountByItemType(scannedItems);
		List<ShoppingCartItem> shoppingCartItems = checkOut.updateShoppingCartWithPriceDetails(itemCounterMap);
		for(ShoppingCartItem cartItem:shoppingCartItems){
			if(cartItem.getCode().equals(ItemEnum.Orange.toString())){
				assertEquals(BasicReferenceDataRetreiver.OrangePrice , cartItem.getPrice());
			}else if(cartItem.getCode().equals(ItemEnum.Apple.toString())){
				assertEquals(BasicReferenceDataRetreiver.ApplePrice , cartItem.getPrice());
			}
		}
	}
	
	@Test
	public void getCountByItemType(){
		CheckOut checkOut = new CheckOut(referenceDataRetriever, priceCalculator, localeUk);
		Map<String, Integer> itemCounterMap = checkOut.getCountByItemType(scannedItems);
		assertEquals(2, itemCounterMap.get(ItemEnum.Orange.toString()));
		assertEquals(1, itemCounterMap.get(ItemEnum.Apple.toString()));
	}

}
