package com.saib.rest.response;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(value = Include.NON_EMPTY)
public class AddDomesticPeriodicConsentResponse extends BaseResponse {



	 
	private Long id;
	private String name;
	private String consentType;
	private String transactionType;
	private String createdBy;
	private Timestamp CreatedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsentType() {
		return consentType;
	}
	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}
 
	 
}
