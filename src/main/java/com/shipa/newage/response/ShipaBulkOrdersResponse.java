package com.shipa.newage.response;

import java.io.Serializable;
import java.util.List;
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
public class ShipaBulkOrdersResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1813866824277527594L;

	private String customerRef;
	private String orderStatus;
	private List<ShipaBulkOrdersPackagesResponse> packages;
	private String shipaRef;

}