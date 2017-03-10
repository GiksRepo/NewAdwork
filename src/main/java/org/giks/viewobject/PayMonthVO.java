package org.giks.viewobject;

public class PayMonthVO {
	private String admissionNo;
	private Integer fromMonth;
	private Integer toMonth;
	private String error;
	
	public Integer getToMonth() {
		return toMonth;
	}
	public void setToMonth(Integer toMonth) {
		this.toMonth = toMonth;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public Integer getFromMonth() {
		return fromMonth;
	}
	public void setFromMonth(Integer fromMonth) {
		this.fromMonth = fromMonth;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
