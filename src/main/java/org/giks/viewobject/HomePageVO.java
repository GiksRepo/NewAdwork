package org.giks.viewobject;

import java.util.Map;

public class HomePageVO 
{
	private String admissionNo;
	private String studentName;
	private String fatherName;
	private String studentClass;
	private String studentSection;
	private String error = "";
	private Map<Long,String> standardList;
	
	public Map<Long, String> getStandardList() {
		return standardList;
	}
	public void setStandardList(Map<Long, String> standardList) {
		this.standardList = standardList;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentSection() {
		return studentSection;
	}
	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}
}
