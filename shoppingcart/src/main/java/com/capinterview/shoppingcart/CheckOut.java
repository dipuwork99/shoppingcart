package com.capinterview.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
/**
 * The main class that processes checkouts.
 * 
 * @author dipuchakrapani
 *
 */
public class CheckOut {

	
	private static final Logger logger = LogManager.getLogger(CheckOut.class);
	public ReferenceDataRetriever referenceDataRetriever = null;
	public PriceCalculator priceCalculator = null;
	public Locale localeCurrency = null;
	public Locale UKlocale = Locale.UK;

	
	
	public CheckOut(ReferenceDataRetriever referenceDataRetriever , PriceCalculator priceCalculator , Locale localeCurrency){
		this.referenceDataRetriever = referenceDataRetriever;
		this.priceCalculator = priceCalculator;
		if(localeCurrency == null){
			localeCurrency = UKlocale;
		}
		this.localeCurrency = localeCurrency;
		
		if(referenceDataRetriever == null || priceCalculator == null ){
			throw new InvalidConfiguration(BasicReferenceDataRetreiver.ERRORMESSAGE);
		}
	}
	
	public static void main(String[] args) {
		if(args == null || args.length ==0){
			logger.error(BasicReferenceDataRetreiver.ENTRYFORMAT);
			return;
		}
		CheckOut checkOut = new CheckOut(new BasicReferenceDataRetreiver(), new BasicPriceCalculator(), Locale.UK);
		Money money = checkOut.processShoping(args);
		checkOut.printTotalCost(money);
	}
	
	/**
	 * Processes a string and creates an EmployeeLink.
	 * 
	 * @param scannedItems The scanned items as string array
	 * 
	 */
	public Money processShoping(String[] scannedItems){
		Map<String , Integer> itemCountByType = getCountByItemType(scannedItems);
		List<ShoppingCartItem> shoppingCartItems = updateShoppingCartWithPriceDetails(itemCountByType);
		Money money = calcuateTotalPrice(shoppingCartItems);
		return money;
	}
	
	/**
	 * Prints the total cost of the amount
	 * 
	 * @param money Prints the total cost
	 * 
	 */
	public void printTotalCost(Money money){
		logger.debug(money.getCurrency().getSymbol(localeCurrency) + money.getPrice());
	}
	
	/**
	 * Calculates the total amount for the shopping
	 * 
	 * @param shoppingCart The shopping cart which contains the scanned items.
	 * @return The total amount for the shopping
	 */
	public Money calcuateTotalPrice(List<ShoppingCartItem> shoppingCart){
		BigDecimal totalAmount = new BigDecimal(0);
		for(ShoppingCartItem cartItem : shoppingCart){
			totalAmount = totalAmount.add(priceCalculator.calculatePrice(cartItem));
		}
		Currency currency = Currency.getInstance(localeCurrency);
		Money money = new Money(currency, totalAmount);
		return money;
	} 

	/**
	 * Processes a string and creates an EmployeeLink.
	 * 
	 * @param itemMap Contains an items and its count
	 * @return An array list updated with the shopping cart item and includes count and price of an item.
	 */
	public List<ShoppingCartItem> updateShoppingCartWithPriceDetails(Map<String , Integer> itemMap){
		List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
		ShoppingCartItem item ;
		for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
		    String code = entry.getKey();
		    Integer quantity = entry.getValue();
		    item  = new ShoppingCartItem(quantity, referenceDataRetriever.getPriceByCode(code), code);
		    items.add(item);
		}
		return items;
	}
	
	
	
	/**
	 * Creates a map from the scanned string list
	 * 
	 * @param cart The scanned items.
	 * @return A Map with key as item and value as the count.
	 */
	public Map<String , Integer> getCountByItemType(String[] cart){
		Map<String , Integer> itemMap = new HashMap<String, Integer>();
		for (String cartItem : cart) {
			Integer counter = itemMap.get(cartItem);
		     if(itemMap.get(cartItem) == null){
		    	 itemMap.put(cartItem, 1);
		     }else{
		    	 itemMap.put(cartItem, counter + 1);
		     }
		}
		return itemMap;
	}		
	
}
