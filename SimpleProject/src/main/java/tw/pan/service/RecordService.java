package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.pan.entity.dto.PaymentDto;
import tw.pan.entity.dto.InsertRentalDto;
import tw.pan.entity.dto.UpdateRentalDto;
import tw.pan.entity.po.Payment;
import tw.pan.entity.po.Rental;
import tw.pan.mappers.PaymentDao;
import tw.pan.mappers.RentalDao;
import tw.pan.utils.exception.DatabaseOperateException;

@Service
public class RecordService {

	@Autowired
	public RentalDao rentalDao;
	@Autowired
	private PaymentDao paymentDao;
	
	
	public List<Rental> getAllRentalRecord(Integer page, Integer size) {
		return rentalDao.selectAllRental(page, size);
	}
	
	public List<Rental> getRentalRecordByCustomer(String name, Integer page, Integer size) {
		return rentalDao.selectRentalByCustomer(name, page, size);
	}
	
	@Transactional(rollbackFor = DatabaseOperateException.class)
	public void addRental(InsertRentalDto rentalDto) {
		rentalDao.insertRental(rentalDto);
	}
	
	@Transactional(rollbackFor = DatabaseOperateException.class)
	public void updateRental(UpdateRentalDto rentalDto) {
		rentalDao.updateRental(rentalDto);
	}
	
	public List<Payment> getAllPaymentRecord(Integer page, Integer size) {
		return paymentDao.selectAllPayment(page, size);
	}
	
	public List<Payment> getPaymentRecordByCustomer(String customer, Integer page, Integer size) {
		return paymentDao.selectPaymentByCustomer(customer, page, size);
	}
	
	public List<Payment> getPaymentRecordByDate(String startTime, String endTime, Integer page, Integer size) {
		return paymentDao.selectPaymentByDate(startTime, endTime, page, size);
	}
	
	@Transactional(rollbackFor = DatabaseOperateException.class)
	public void addPayment(PaymentDto paymentDto) {
		paymentDao.insertPayment(paymentDto);
	}
}
