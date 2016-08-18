package com.capinterview.shoppingcart;

import java.math.BigDecimal;

/**
 * Implementations of this interface will provide how price will be calculated for an item
 * 
 * @author dipuchakrapani
 *
 */
public interface PriceCalculator {
	
	/**
	 * Processes a string and creates an EmployeeLink.
	 * 
	 * @param item The item to be priced
	 * @return The total price for the item
	 */
	public BigDecimal calculatePrice(Item item);

}
