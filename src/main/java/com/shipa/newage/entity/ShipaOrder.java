package com.shipa.newage.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "shipaorder")
public class ShipaOrder extends Auditable<String> {

	@Id 													// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// auto increment
	@Column(name = "id")
	private Long id;

	@Column(name = "customerrefno")
	private String customerRefNo;

	@Column(name = "ordertype")
	private String orderType;

	@Column(name = "category")
	private String category;

	@Column(name = "origincontactname")
	private String originContactName;

	@Column(name = "origincontactno")
	private String originContactNo;

	@Column(name = "origincity")
	private String originCity;

	@Column(name = "origincountry")
	private String originCountry;

	@Column(name = "originaddress")
	private String originAddress;

	@Column(name = "destinationcontactname")
	private String destinationContactName;

	@Column(name = "destinationcontactno")
	private String destinationContactNo;

	@Column(name = "destinationcity")
	private String destinationCity;

	@Column(name = "destinationcountry")
	private String destinationCountry;

	@Column(name = "destinationaddress")
	private String destinationAddress;

	@Column(name = "shipaapistatus")
	private String shipaApiStatus;

	@Column(name = "shiparef")
	private String shipaRef;

	@Lob
	@Column(name = "awbpdf")
	private byte[] awbPdf;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "shipaorderid", referencedColumnName = "id")
	private List<ShipaOrderPackages> shipaOrderPackages;

}