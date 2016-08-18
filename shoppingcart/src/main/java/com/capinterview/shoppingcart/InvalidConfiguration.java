package com.capinterview.shoppingcart;

/**
 * Exception to be thrown when configuration is invalid
 * 
 * @author dipuchakrapani
 *
 */
public class InvalidConfiguration extends RuntimeException {

	/**
	 * Serilization id.
	 */
	private static final long serialVersionUID = 493162326199826225L;

	public InvalidConfiguration(String message){
		super(message);
	}
 }
