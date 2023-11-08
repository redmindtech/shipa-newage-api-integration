package com.shipa.newage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shipa.newage.entity.ShipaOrder;
import com.shipa.newage.repository.ShipaOrderRepository;
import com.shipa.newage.request.CreateShipaRefOriginRequest;
import com.shipa.newage.request.CreateShipaRefPackagesRequest;
import com.shipa.newage.request.CreateShipaRefRequest;
import com.shipa.newage.response.ShipaBulkOrdersListResponse;
import com.shipa.newage.response.ShipaBulkOrdersResponse;
import com.shipa.newage.response.ShipaOrderStoryResponse;
import static com.shipa.newage.constants.Constants.SHIPA_ORDERS_BULK_POST_URL;
import static com.shipa.newage.constants.Constants.SHIPA_API_STATUS_AWB_CREATED;
import static com.shipa.newage.constants.Constants.SHIPA_ORDERS_GET_PDF;
import static com.shipa.newage.constants.Constants.SHIPA_API_PARAM1_ORDER_ID;
import static com.shipa.newage.constants.Constants.SHIPA_API_PARAM2_API_KEY;
import static com.shipa.newage.constants.Constants.SHIPA_ORDERS_GET_STORY;

/**
 * @author SureshKumar
 * 15-Sep-2023
 */

@Service
public class ShipaOrderServiceImpl implements ShipaOrderService {

	@Autowired	
	ShipaOrderRepository shipaOrderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${shipa.environment.url}")
    private String shipaEnvironmentUrl;

	@Value("${shipa.environment.secret_key}")
    private String shipaEnvironmentApiKey;

	public List<ShipaOrder> findAll() {
		return shipaOrderRepository.findAll();
	}

	public Optional<ShipaOrder> findById(Long id) {
		return shipaOrderRepository.findById(id);
	}

	public List<ShipaOrder> findByListOfIds(List<Long> ids) {
		return shipaOrderRepository.findAllById(ids);
	}

	public List<ShipaOrder> findByShipaApiStatus(String shipaApiStatus) {
		return shipaOrderRepository.findByShipaApiStatus(shipaApiStatus);
	}

	public List<ShipaOrder> findByCustomerRefNo(List<String> customerRefNo) {
		return shipaOrderRepository.findByCustomerRefNo(customerRefNo);
	}

	@Async
	public void callOrdersBulkPostApi(List<ShipaOrder> shipaOrderList) throws Exception {

		Map<String, String> urlParamsMap = new HashMap<>();
		urlParamsMap.put(SHIPA_API_PARAM2_API_KEY, shipaEnvironmentApiKey);
		List<CreateShipaRefRequest> createShipaRefRequestList = new ArrayList<>();
		for(ShipaOrder shipaOrder : shipaOrderList) {
			if(!createShipaRefRequestList.isEmpty())
				createShipaRefRequestList.clear();

			try {
				CreateShipaRefRequest createShipaRefRequest = new CreateShipaRefRequest();
				createShipaRefRequestList.add(mapShipaOderToRequest(shipaOrder, createShipaRefRequest));
				String shipaBulkOrdersResponse = restTemplate.postForObject(
						new StringBuilder().append(shipaEnvironmentUrl).append(SHIPA_ORDERS_BULK_POST_URL).toString(), 
						createShipaRefRequestList, String.class, urlParamsMap);

				if(null != shipaBulkOrdersResponse) {
					ObjectMapper mapper = new ObjectMapper();
					ShipaBulkOrdersResponse[] shipaBulkOrdersResponse1 = mapper.readValue(shipaBulkOrdersResponse, 
							ShipaBulkOrdersResponse[].class);

					if(null != shipaBulkOrdersResponse1) {
						shipaOrder.setShipaRef(shipaBulkOrdersResponse1[0].getShipaRef());
						shipaOrder.setShipaApiStatus(SHIPA_API_STATUS_AWB_CREATED);
						shipaOrderRepository.save(shipaOrder);
					}
				}
			} catch(Exception callOrdersBulkPostApiException) {
				callOrdersBulkPostApiException.printStackTrace();
			}
		}
	}

	private CreateShipaRefRequest mapShipaOderToRequest(ShipaOrder shipaOrder, CreateShipaRefRequest 
			createShipaRefRequest) {
		if(null != shipaOrder.getCustomerRefNo())
			createShipaRefRequest.setCustomerRef(shipaOrder.getCustomerRefNo());
		if(null != shipaOrder.getOrderType())
			createShipaRefRequest.setType(shipaOrder.getOrderType());
		if(null != shipaOrder.getCategory())
			createShipaRefRequest.setCategory(shipaOrder.getCategory());

		CreateShipaRefOriginRequest origin = new CreateShipaRefOriginRequest();
		if(null != shipaOrder.getOriginContactName())
			origin.setContactName(shipaOrder.getOriginContactName());
		if(null != shipaOrder.getOriginContactNo())
			origin.setContactNo(shipaOrder.getOriginContactNo());
		if(null != shipaOrder.getOriginCity())
			origin.setCity(shipaOrder.getOriginCity());
		if(null != shipaOrder.getOriginCountry())
			origin.setCountry(shipaOrder.getOriginCountry());
		if(null != shipaOrder.getOriginAddress())
			origin.setAddress(shipaOrder.getOriginAddress());
		createShipaRefRequest.setOrigin(origin);

		CreateShipaRefOriginRequest destination = new CreateShipaRefOriginRequest();
		if(null != shipaOrder.getDestinationContactName())
			destination.setContactName(shipaOrder.getDestinationContactName());
		if(null != shipaOrder.getDestinationContactNo())
			destination.setContactNo(shipaOrder.getDestinationContactNo());
		if(null != shipaOrder.getDestinationCity())
			destination.setCity(shipaOrder.getDestinationCity());
		if(null != shipaOrder.getDestinationCountry())
			destination.setCountry(shipaOrder.getDestinationCountry());
		if(null != shipaOrder.getDestinationAddress())
			destination.setAddress(shipaOrder.getDestinationAddress());
		createShipaRefRequest.setDestination(destination);

		List<CreateShipaRefPackagesRequest> packagesList = new ArrayList<>();
		if(null != shipaOrder && null != shipaOrder.getShipaOrderPackages() && !shipaOrder.getShipaOrderPackages().isEmpty()) {
			shipaOrder.getShipaOrderPackages().stream().forEach(action -> {
				CreateShipaRefPackagesRequest createShipaRefPackagesRequest = new CreateShipaRefPackagesRequest();
				createShipaRefPackagesRequest.setCustomerRef(action.getCustomerRefNo());
				createShipaRefPackagesRequest.setName(action.getName());
				packagesList.add(createShipaRefPackagesRequest);
			});
		}
		if(!packagesList.isEmpty())
			createShipaRefRequest.setPackages(packagesList);

		return createShipaRefRequest;
	}

	@Async
	public void updateShipaAwbPDF(List<ShipaOrder> shipaOrderList) throws Exception {

		Map<String, String> urlParamsMap = new HashMap<>();
		for(ShipaOrder shipaOrder : shipaOrderList) {
			urlParamsMap.put(SHIPA_API_PARAM1_ORDER_ID, shipaOrder.getCustomerRefNo());
			urlParamsMap.put(SHIPA_API_PARAM2_API_KEY, shipaEnvironmentApiKey);

			try {
				byte[] shipaBulkOrdersResponse = restTemplate.getForObject(
						new StringBuilder().append(shipaEnvironmentUrl).append(SHIPA_ORDERS_GET_PDF).toString(), 
						byte[].class, urlParamsMap);
				if(null != shipaBulkOrdersResponse) {
					shipaOrder.setAwbPdf(shipaBulkOrdersResponse);
					shipaOrderRepository.save(shipaOrder);
				}
			} catch(Exception updateShipaAwbPDFException) {
				updateShipaAwbPDFException.printStackTrace();
			}
		}
	}

	@Async
	public void updateShipaStory(List<ShipaOrder> shipaOrderList) throws Exception {

		Map<String, String> urlParamsMap = new HashMap<>();
		for(ShipaOrder shipaOrder : shipaOrderList) {
			urlParamsMap.put(SHIPA_API_PARAM1_ORDER_ID, shipaOrder.getCustomerRefNo());
			urlParamsMap.put(SHIPA_API_PARAM2_API_KEY, shipaEnvironmentApiKey);
			try {
				String shipaOrderStoryResponse = restTemplate.getForObject(
						new StringBuilder().append(shipaEnvironmentUrl).append(SHIPA_ORDERS_GET_STORY).toString(), 
						String.class, urlParamsMap);
				if(null != shipaOrderStoryResponse) {
					ObjectMapper mapper = new ObjectMapper();
					ShipaOrderStoryResponse[] shipaOrderStoryResponse1 = mapper.readValue(shipaOrderStoryResponse, 
							ShipaOrderStoryResponse[].class);
					shipaOrder.setShipaApiStatus(shipaOrderStoryResponse1[0].getStatus());
					shipaOrderRepository.save(shipaOrder);
				}
			} catch(Exception updateShipaStoryException) {
				updateShipaStoryException.printStackTrace();
			}
		}
	}

}