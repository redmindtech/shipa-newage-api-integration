package com.shipa.newage.exceptionhandling;

import java.io.Serializable;

/**
 * @author SureshKumar
* 12-Sep-2023
*/

public class ResourceNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 874598819214454824L;

	public ResourceNotFoundException() {
		super();
    }

	public ResourceNotFoundException(final String message){
        super(message);
    }

}