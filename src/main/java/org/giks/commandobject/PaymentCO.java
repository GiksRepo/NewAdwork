package org.giks.commandobject;

import java.util.Date;

public class PaymentCO 
{
	private Long Id;
	private StudentCO student;
	private Long accountNumber;
	private Long amountPaid;
	private EnumerationCO status;
	private Date paymentDate;
	private Date paymentTo;
	private Date paymentForm;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public StudentCO getStudent() {
		return student;
	}

	public void setStudent(StudentCO student) {
		this.student = student;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public EnumerationCO getStatus() {
		return status;
	}

	public void setStatus(EnumerationCO status) {
		this.status = status;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(Date paymentTo) {
		this.paymentTo = paymentTo;
	}

	public Date getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(Date paymentForm) {
		this.paymentForm = paymentForm;
	}
	
}
