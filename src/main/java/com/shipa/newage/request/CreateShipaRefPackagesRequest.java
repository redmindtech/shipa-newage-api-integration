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
public class CreateShipaRefPackagesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7729654396285578339L;

	@JsonProperty("name")
	private String name;

	@JsonProperty("customerRef")
	private String customerRef;

}