package com.shipa.newage.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shipa.newage.entity.ShipaOrder;

/**
 * @author SureshKumar
 * 12-Sep-2023
 */

@Repository
public interface ShipaOrderRepository extends JpaRepository<ShipaOrder, Long> {

	@Query("from ShipaOrder where shipaApiStatus = :shipaApiStatus")
	public List<ShipaOrder> findByShipaApiStatus(String shipaApiStatus);

	@Query("from ShipaOrder where customerRefNo IN :customerRefNo")
	public List<ShipaOrder> findByCustomerRefNo(List<String> customerRefNo);

	@Query("from ShipaOrder where shipaRef = :shipaRef")
	public List<ShipaOrder> findByShipaRefNo(String shipaRef);

}