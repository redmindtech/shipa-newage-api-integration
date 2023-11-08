package com.shipa.newage.response;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SureshKumar
 * 15-Sep-2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ShipaBulkOrdersPackagesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 238713662621149743L;

	private String customerRef;
	private String shipaRef;

}