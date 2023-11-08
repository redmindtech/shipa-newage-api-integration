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
public class ShipaBulkOrdersListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5468931914562067703L;

	private List<ShipaBulkOrdersResponse> shipaBulkOrdersResponse;

}