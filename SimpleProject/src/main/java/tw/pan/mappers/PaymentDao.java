package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.dto.PaymentDto;
import tw.pan.entity.po.Payment;

public interface PaymentDao {

	public List<Payment> selectAllPayment(Integer page, Integer size);
	
	public List<Payment> selectPaymentByCustomer(String name, Integer page, Integer size);
	
	public List<Payment> selectPaymentByDate(String startTime, String endTime, Integer page, Integer size);
	
	public void insertPayment(PaymentDto paymentDto);
}
