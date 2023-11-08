package com.shipa.newage.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shipa.newage.entity.ShipaOrder;
import com.shipa.newage.service.ShipaOrderService;
import com.shipa.newage.exceptionhandling.ResourceNotFoundException;
import com.shipa.newage.mapstruct.ShipaOrderMapper;
import static com.shipa.newage.constants.Constants.COMMON_NOT_FOUND;
import java.util.List;
import static com.shipa.newage.constants.Constants.SHIPA_GENERIC_SUCCESS_MESSAGE;

/**
 * @author SureshKumar
 * 15-Sep-2023
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT }, maxAge = 3600, 
allowedHeaders = "*")
@RestController
@RequestMapping("/shipa/newAgeIntegration")
public class ShipaOrderController {

	@Autowired
	ShipaOrderService shipaOrderService;

	@Autowired
	ShipaOrderMapper shipaOrderMapper;

	public ShipaOrderController() {
		shipaOrderMapper = Mappers.getMapper(ShipaOrderMapper.class);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getShipaOrderById(@PathVariable Long id) throws Exception {

		ShipaOrder shipaOrder = null;
		try {
			shipaOrder = shipaOrderService.findById(id).orElseThrow( () -> new ResourceNotFoundException
					(COMMON_NOT_FOUND));
		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception getShipaOrderByIdException) {
				throw new Exception(getShipaOrderByIdException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(shipaOrderMapper.shipaOrderToShipaOrderResponse(shipaOrder));
	}

	@GetMapping("/shipaApiStatus")
	public ResponseEntity<?> getShipaOdersByShipaApiStatus(@RequestParam(value="shipaApiStatus") String shipaApiStatus) 
			throws Exception {

		List<ShipaOrder> shipaOrderList = null;
		try {
			shipaOrderList = shipaOrderService.findByShipaApiStatus(shipaApiStatus);
			if(null == shipaOrderList || shipaOrderList.isEmpty())
				throw new ResourceNotFoundException(COMMON_NOT_FOUND);
		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception getShipaOdersByShipaApiStatusException) {
				throw new Exception(getShipaOdersByShipaApiStatusException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(shipaOrderMapper.shipaOrderToShipaOrderResponse
				(shipaOrderList));
	}

	@GetMapping("/shipaApiStatus/all")
	public ResponseEntity<?> getAllShipaOders() throws Exception {

		List<ShipaOrder> shipaOrderList = null;
		try {
			shipaOrderList = shipaOrderService.findAll();
			if(null == shipaOrderList || shipaOrderList.isEmpty())
				throw new ResourceNotFoundException(COMMON_NOT_FOUND);
		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception getAllShipaOdersException) {
			throw new Exception(getAllShipaOdersException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(shipaOrderMapper.shipaOrderToShipaOrderResponse
				(shipaOrderList));
	}

	@PostMapping("/createShipaRef")
	public ResponseEntity<?> createShipaRef(@RequestBody(required=true) List<String> wmsReferenceNumber) throws Exception {

		List<ShipaOrder> shipaOrderList = null;
		try {
			shipaOrderList = shipaOrderService.findByCustomerRefNo(wmsReferenceNumber);
			if(null == shipaOrderList || shipaOrderList.isEmpty())
				throw new ResourceNotFoundException(COMMON_NOT_FOUND);

			shipaOrderService.callOrdersBulkPostApi(shipaOrderList);

		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception createShipaRefException) {
			throw new Exception(createShipaRefException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(SHIPA_GENERIC_SUCCESS_MESSAGE);
	}

	@PostMapping("/updateShipaAwbPDF")
	public ResponseEntity<?> updateShipaAwbPDF(@RequestBody(required=true) List<String> wmsReferenceNumber) throws Exception {

		List<ShipaOrder> shipaOrderList = null;
		try {
			shipaOrderList = shipaOrderService.findByCustomerRefNo(wmsReferenceNumber);
			if(null == shipaOrderList || shipaOrderList.isEmpty())
				throw new ResourceNotFoundException(COMMON_NOT_FOUND);

			shipaOrderService.updateShipaAwbPDF(shipaOrderList);

		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception updateShipaAwbPDFException) {
			throw new Exception(updateShipaAwbPDFException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(SHIPA_GENERIC_SUCCESS_MESSAGE);
	}

	@PostMapping("/updateShipaStory")
	public ResponseEntity<?> updateShipaStory(@RequestBody(required=true) List<String> wmsReferenceNumber) throws Exception {

		List<ShipaOrder> shipaOrderList = null;
		try {
			shipaOrderList = shipaOrderService.findByCustomerRefNo(wmsReferenceNumber);
			if(null == shipaOrderList || shipaOrderList.isEmpty())
				throw new ResourceNotFoundException(COMMON_NOT_FOUND);

			shipaOrderService.updateShipaStory(shipaOrderList);

		} catch(ResourceNotFoundException resourceNotFoundDetailsException) {
			throw new ResourceNotFoundException(resourceNotFoundDetailsException.toString());
		} catch(Exception updateShipaStoryException) {
			throw new Exception(updateShipaStoryException.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(SHIPA_GENERIC_SUCCESS_MESSAGE);
	}

}