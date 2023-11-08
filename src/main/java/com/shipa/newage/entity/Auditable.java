package com.shipa.newage.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
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
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3073550074123115441L;

	@CreatedBy
	//@Column(name = "createdBy", updatable = false)
    protected U createdBy;

	@CreatedDate
	//@Column(name = "creationDate", updatable = false)
	protected LocalDateTime creationDate;

	@LastModifiedBy
	//@Column(name = "lastModifiedBy")
    protected U lastModifiedBy;

	@LastModifiedDate
	//@Column(name = "lastModifiedDate")
	protected LocalDateTime lastModifiedDate;

}