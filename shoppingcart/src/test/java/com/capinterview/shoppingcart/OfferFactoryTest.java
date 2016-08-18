package com.capinterview.shoppingcart;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for OfferFactor
 * 
 * @author dipuchakrapani
 *
 */
public class OfferFactoryTest {
	
	public static final String INVALIDITEM = "invaliditem";
	
	@Test
	public void getOfferFactory(){
		ReferenceDataRetriever referenceDataRetriever = new BasicReferenceDataRetreiver();
		OfferFactory factory = new OfferFactory(referenceDataRetriever);
		OfferType offerType = factory.getOfferType(ItemEnum.Orange.toString());
		assertTrue(offerType instanceof TwoForOneOffer);
		offerType = factory.getOfferType(ItemEnum.Apple.toString());
		assertTrue(offerType instanceof ThreeForTwoOffer);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getOfferFactoryException(){
		ReferenceDataRetriever referenceDataRetriever = new BasicReferenceDataRetreiver();
		OfferFactory factory = new OfferFactory(referenceDataRetriever);
		OfferType offerType = factory.getOfferType(INVALIDITEM);
		assertTrue(offerType instanceof TwoForOneOffer);
		
		
	}

}
