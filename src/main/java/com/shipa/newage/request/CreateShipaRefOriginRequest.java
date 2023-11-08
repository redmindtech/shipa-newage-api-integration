package com.shipa.newage.request;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SureshKumar
 * 13-Oct-2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateShipaRefOriginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6265719240638452652L;

	@JsonProperty("contactName")
	private String contactName;

	@JsonProperty("contactNo")
	private String contactNo;

	@JsonProperty("city")
	private String city;

	@JsonProperty("country")
	private String country;

	@JsonProperty("address")
	private String address;

}