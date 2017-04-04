package org.giks.services;

import java.util.Map;

import org.giks.daos.FeeDaoImpl;
import org.giks.daos.StudentDaoImpl;
import org.giks.serviceInterfaces.FeeServiceIn;
import org.giks.viewobject.FeeVO;
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
		if(StringUtils.isEmpty(admissionNo)){
			payMonthVO.setError("Admission number not found!");
		}else{
			Integer fromMonth = feeDaoImpl.getFromFeeMonth(Long.valueOf(admissionNo));
			if(fromMonth == -1) payMonthVO.setError("Some error occured!");
			else if(fromMonth == 0) payMonthVO.setError("Admission number not fount!");
			else payMonthVO.setFromMonth(fromMonth);
		}
		return payMonthVO;
	}
	@Override
	public FeeVO getAllFees(PayMonthVO payMonthVO) {
		// TODO Auto-generated method stub
		FeeVO feeVO = new FeeVO();
		String admissionNo = payMonthVO.getAdmissionNo();
		if(StringUtils.isEmpty(admissionNo) || StringUtils.isEmpty(payMonthVO.getToMonth())){
			feeVO.setError("Admission number or from fee not found!");
			feeVO.setFromMonth(feeDaoImpl.getFromFeeMonth(Long.valueOf(admissionNo)));
		}else{
			try{
			Map <String, String> allFees = feeDaoImpl.getAllFees(payMonthVO);
			if(allFees.isEmpty()) feeVO.setError("Some error occured!");
			else feeVO.setFees(allFees);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return feeVO;
	}

}
