package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.pan.entity.Payment;
import tw.pan.entity.Rental;
import tw.pan.mappers.PaymentDao;
import tw.pan.mappers.RentalDao;

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
	
	public void addRental(Rental rental) {
		rentalDao.insertRental(rental);
	}
	
	public void updateRental(Rental rental) {
		rentalDao.updateRental(rental);
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
	
	public void addPayment(Payment payment) {
		paymentDao.insertPayment(payment);
	}
}
