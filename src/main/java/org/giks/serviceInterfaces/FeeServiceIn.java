package org.giks.serviceInterfaces;

import org.giks.viewobject.FeeVO;
import org.giks.viewobject.PayMonthVO;

public interface FeeServiceIn {
	public PayMonthVO getFromFee(PayMonthVO payMonthVO);
	public FeeVO getAllFees(PayMonthVO payMonthVO);
}
