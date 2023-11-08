package com.shipa.newage.response;

import java.io.Serializable;
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
public class ShipaOrderStoryResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5238959374915675541L;

	private Long date;
	private String details;
	private String status;
	private String statusCode;

}