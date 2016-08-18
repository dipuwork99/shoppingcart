package com.capinterview.shoppingcart;

/**
 * Factory class that retrieves the offer type for a shopping item
 * 
 * @author dipuchakrapani
 *
 */
public class OfferFactory {
	
	public ReferenceDataRetriever referenceDataRetriever = null;
	public OfferFactory(ReferenceDataRetriever referenceDataRetriever){
		this.referenceDataRetriever = referenceDataRetriever;
	}
	
	 public  OfferType getOfferType(String offerType){
	      if(offerType == null){
	         return null;
	      }		
	      String className = referenceDataRetriever.getOfferByCode(offerType);
	      Class cls = null;
	      OfferType obj = null;  
		try {
			cls = Class.forName(className);
			obj = (OfferType) cls.newInstance();  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	       
	     return obj;
	   }
}
