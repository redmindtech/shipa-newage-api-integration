package com.shipa.newage.service;

import java.util.List;
import java.util.Optional;
import com.shipa.newage.entity.ShipaOrder;

/**
 * @author SureshKumar
 * 15-Sep-2023
 */

public interface ShipaOrderService {

	public List<ShipaOrder> findAll();

	public Optional<ShipaOrder> findById(Long id);

	public List<ShipaOrder> findByListOfIds(List<Long> ids);

	public List<ShipaOrder> findByShipaApiStatus(String shipaApiStatus);

	public List<ShipaOrder> findByCustomerRefNo(List<String> customerRefNo);

	public void callOrdersBulkPostApi(List<ShipaOrder> shipaOrderList) throws Exception;

	public void updateShipaAwbPDF(List<ShipaOrder> shipaOrderList) throws Exception;

	public void updateShipaStory(List<ShipaOrder> shipaOrderList) throws Exception;

}