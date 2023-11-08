package com.shipa.newage.request;

import java.io.Serializable;
import java.util.List;
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
public class CreateShipaRefRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2750083859674888304L;

	@JsonProperty("customerRef")
	private String customerRef;

	@JsonProperty("type")
	private String type;

	@JsonProperty("category")
	private String category;

	@JsonProperty("origin")
	private CreateShipaRefOriginRequest origin;

	@JsonProperty("destination")
	private CreateShipaRefOriginRequest destination;

	@JsonProperty("packages")
	private List<CreateShipaRefPackagesRequest> packages;

}