package org.giks.commandobject;

import org.giks.domainobject.Student;
import org.giks.domainobject.StudentFee;
import org.giks.viewobject.HomePageVO;
import org.springframework.util.StringUtils;

public class StudentCO 
{
	private Long admissionNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String address;
	private String dateOfBirth;
	private String section;
	private String classId;
	private Long fee;
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Long getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public StudentCO() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentCO(HomePageVO vo) {
		// TODO Auto-generated constructor stub
		if(isNumeric(vo.getAdmissionNo()))
			admissionNo = Long.valueOf(vo.getAdmissionNo());
		
		String name = vo.getStudentName();
		
		if(!StringUtils.isEmpty(name)){
			String[] nameArr = name.trim().split(" ");
			switch (nameArr.length)
			{
			case 1:
				firstName = nameArr[0];
				break;
			case 2:
				firstName = nameArr[0];
				lastName = nameArr[1];
				break;
			case 3:
				firstName = nameArr[0];
				middleName = nameArr[1];
				lastName = nameArr[2];
				break;
			}
			
			fatherName = vo.getFatherName();
			
			section = vo.getStudentSection();
			
			classId = vo.getStudentClass();
		}
	}
	
	public StudentCO(Student student) {
		// TODO Auto-generated constructor stub
			admissionNo = student.getAdmissionNo();
			firstName = student.getFirstName();
			middleName = student.getMiddleName();
			lastName = student.getLastName();
			fatherName = student.getFatherName();
			section = student.getCategory().getCategory().getDescription();
			classId = String.valueOf(student.getStandard().getName());
			address = student.getAddress();
			dateOfBirth = student.getDateOfBirth();
			
			System.out.println("section : "+section);
			
			for(StudentFee sf : student.getFees()){
				fee+=sf.getFee().getAmount();
			}
			System.out.println("Fee : "+fee);
		}
	
	public Boolean validate(){
		if(admissionNo != null || (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(fatherName) && !StringUtils.isEmpty(section) && !StringUtils.isEmpty(classId)))
			return true;
		return false;
	}
	
	public Boolean isNumeric(String sadmissionNo){
		try{
			Long.valueOf(sadmissionNo);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			return false;
		}
		return true;
	}
}
