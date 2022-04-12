package com.saib.dto;


/**
 * @author Ishrat Hussain
 *
 */
public class BLZServiceDTO {
	
	
	
	
	@Override
	public String toString() {
		return "BLZServiceDTO [blzCode=" + blzCode + ", detailsType=" + detailsType + "]";
	}

	private String blzCode;
	private DetailsType detailsType;
	
	
	public DetailsType getDetailsType() {
		return detailsType;
	}

	public void setDetailsType(DetailsType detailsType) {
		this.detailsType = detailsType;
	}

	public String getBlzCode() {
		return blzCode;
	}

	public void setBlzCode(String blzCode) {
		this.blzCode = blzCode;
	}
	
	
	
	

}
