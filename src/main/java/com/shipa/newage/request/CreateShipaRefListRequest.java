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
public class CreateShipaRefListRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440427953831276221L;

	@JsonProperty("createShipaRef")
	private List<CreateShipaRefRequest> createShipaRef;

}