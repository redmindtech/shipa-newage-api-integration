package com.shipa.newage.response;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SureshKumar
 * 16-Sep-2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ShipaOrderStoryListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3570953576338852716L;

	private List<ShipaOrderStoryResponse> shipaOrderStory;

}