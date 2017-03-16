package org.giks.domainobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "amount_paid")
	private Long amountPaid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status")
	private Enumeration status;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "payment_to")
	private Integer paymentTo;
	
	@Column(name = "payment_from")
	private Integer paymentForm;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
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

	public Enumeration getStatus() {
		return status;
	}

	public void setStatus(Enumeration status) {
		this.status = status;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(Integer paymentTo) {
		this.paymentTo = paymentTo;
	}

	public Integer getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(Integer paymentForm) {
		this.paymentForm = paymentForm;
	}
	
	
	
}
