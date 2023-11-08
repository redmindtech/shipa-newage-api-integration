package com.shipa.newage.response;

import java.io.Serializable;
import java.util.List;
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
public class ShipaOrderResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3051193684433754422L;

	private Long id;
	private String customerRefNo;
	private String orderType;
	private String category;
	private String originContactName;
	private String originContactNo;
	private String originCity;
	private String originCountry;
	private String originAddress;
	private String destinationContactName;
	private String destinationContactNo;
	private String destinationCity;
	private String destinationCountry;
	private String destinationAddress;
	private String shipaApiStatus;
	private String shipaRef;
	private byte[] awbPdf;
	private String createdBy;
	private String creationDate;
	private String lastModifiedBy;
	private String lastModifiedDate;
	private List<ShipaOrderPackagesResponse> shipaOrderPackages;

}