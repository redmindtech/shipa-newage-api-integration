package com.shipa.newage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "shipaorderpackages")
public class ShipaOrderPackages extends Auditable<String> {

	@Id 													// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// auto increment
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "customerrefno")
	private String customerRefNo;

}