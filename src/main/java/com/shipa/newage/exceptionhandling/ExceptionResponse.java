package com.shipa.newage.exceptionhandling;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SureshKumar
 * 12-Sep-2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1432189331357509340L;

	private String errorMessage;
	private String requestedURI;

}