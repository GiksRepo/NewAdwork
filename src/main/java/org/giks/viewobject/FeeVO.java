package org.giks.viewobject;

import java.util.Map;

public class FeeVO {
	
	private String admissionNo;
	private String error = "";
	private Map<String, String> fees;
	private Integer fromMonth;
	
	
	
	public Integer getFromMonth() {
		return fromMonth;
	}
	public void setFromMonth(Integer fromMonth) {
		this.fromMonth = fromMonth;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Map<String, String> getFees() {
		return fees;
	}
	public void setFees(Map<String, String> fees) {
		this.fees = fees;
	}
	
	
}
