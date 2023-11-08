package com.shipa.newage.response;

import java.io.Serializable;
import org.springframework.stereotype.Component;
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
@Component
public class ShipaOrderPackagesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1287236751706125701L;

	private Long id;
	private String name;
	private String customerRefNo;
	private byte[] shipaorderid;
	private String createdBy;
	private String creationDate;
	private String lastModifiedBy;
	private String lastModifiedDate;

}