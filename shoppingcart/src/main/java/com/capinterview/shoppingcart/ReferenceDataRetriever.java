package com.capinterview.shoppingcart;

import java.math.BigDecimal;

/**
 * Concrete implementations would provide how ReferenceData is retrieved
 * 
 * @author dipuchakrapani
 *
 */
public interface ReferenceDataRetriever {
	
	/**
	 * Processes a string and creates an EmployeeLink.
	 * 
	 * @param code The code of the item for which the price has to be retreived.
	 * @return The Price of the amount.
	 */
	public BigDecimal getPriceByCode(String code);

	
	
}
