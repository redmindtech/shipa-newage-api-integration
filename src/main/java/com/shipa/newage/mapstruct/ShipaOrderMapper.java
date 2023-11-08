package com.shipa.newage.mapstruct;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.shipa.newage.entity.ShipaOrder;
import com.shipa.newage.response.ShipaOrderResponse;
import static com.shipa.newage.constants.Constants.COMMON_RESPONSE_CREATION_DATE;
import static com.shipa.newage.constants.Constants.COMMON_RESPONSE_LAST_MODIFIED_DATE;
import static com.shipa.newage.constants.Constants.COMMON_RESPONSE_DATE_FORMAT;

/**
 * @author SureshKumar
 * 12-Sep-2023
*/

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShipaOrderMapper {

	@Mapping(target=COMMON_RESPONSE_CREATION_DATE, source=COMMON_RESPONSE_CREATION_DATE, dateFormat=COMMON_RESPONSE_DATE_FORMAT)
	@Mapping(target=COMMON_RESPONSE_LAST_MODIFIED_DATE, source=COMMON_RESPONSE_LAST_MODIFIED_DATE, dateFormat=COMMON_RESPONSE_DATE_FORMAT)
	ShipaOrderResponse shipaOrderToShipaOrderResponse(ShipaOrder shipaOrder);

	@Mapping(target=COMMON_RESPONSE_CREATION_DATE, source=COMMON_RESPONSE_CREATION_DATE, dateFormat=COMMON_RESPONSE_DATE_FORMAT)
	@Mapping(target=COMMON_RESPONSE_LAST_MODIFIED_DATE, source=COMMON_RESPONSE_LAST_MODIFIED_DATE, dateFormat=COMMON_RESPONSE_DATE_FORMAT)
	List<ShipaOrderResponse> shipaOrderToShipaOrderResponse(List<ShipaOrder> shipaOrder);

}