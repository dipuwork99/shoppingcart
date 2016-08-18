package com.capinterview.shoppingcart;

import java.math.BigDecimal;

public class BasicReferenceDataRetreiver implements ReferenceDataRetriever{

	// Cost of Orange
	public static final  BigDecimal OrangePrice = new BigDecimal(".25");
	// Cost of Apple
	public static final  BigDecimal ApplePrice = new BigDecimal(".60");
	// Invalid configuration
	public static final String ERRORMESSAGE = "Invalid Configuration";
	// Invalid configuration
	public static final String NOITEMSINSHOPPINGCART = "Shopping cart does not have any items";
	// Shooping cart forma
	public static final String ENTRYFORMAT = "Items should be entered as either Orange or Apple each item followed by space example Orange Apple Orange ";
	//Implementing class for Three for two offers
	public static final  String TwoForOneOffer = "com.capinterview.shoppingcart.ThreeForTwoOffer";
	//Implementing class for Three for two offers
	public static final  String ThreeForTwoOffer = "com.capinterview.shoppingcart.TwoForOneOffer";
	@Override
	public BigDecimal getPriceByCode(String code) {
		ItemEnum item = ItemEnum.valueOf(code);
		switch (item) {
        case Apple:
            return ApplePrice;
                
        case Orange:
            
            return OrangePrice;
           
        default:
      
            return null;
		}
	}
	
	@Override
	public String getOfferByCode(String code) {
		ItemEnum item = ItemEnum.valueOf(code);
		switch (item) {
        case Apple:
            return TwoForOneOffer;
                
        case Orange:
            
            return ThreeForTwoOffer;
           
        default:
      
            return null;
    }
		
	}

}


