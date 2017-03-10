package org.giks.services;

import org.giks.daos.FeeDaoImpl;
import org.giks.daos.StudentDaoImpl;
import org.giks.serviceInterfaces.FeeServiceIn;
import org.giks.viewobject.PayMonthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FeeService implements FeeServiceIn {

	@Autowired
	private FeeDaoImpl feeDaoImpl;
	@Override
	public PayMonthVO getFromFee(PayMonthVO payMonthVO) {
		String admissionNo = payMonthVO.getAdmissionNo();
		System.out.println("admissionNo : "+admissionNo);
		if(StringUtils.isEmpty(admissionNo)){
			payMonthVO.setError("Admission number not fount!");
		}else{
			Integer fromMonth = feeDaoImpl.getFromFeeMonth(Long.valueOf(admissionNo));
			if(fromMonth == -1) payMonthVO.setError("Some error occured!");
			else if(fromMonth == 0) payMonthVO.setError("Admission number not fount!");
			else payMonthVO.setFromMonth(fromMonth);
		}
		return payMonthVO;
	}

}
