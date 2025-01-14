package tw.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.pan.entity.po.Payment;
import tw.pan.entity.po.Rental;
import tw.pan.service.RecordService;
import tw.pan.utils.StringTool;

@RestController
@RequestMapping(value = "/index/api")
@CrossOrigin
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	// 搜尋租借紀錄
	@GetMapping(value = "/rental/search")
	public List<Rental> getRentalByCustomer(@RequestParam String customer,
			@RequestParam Integer page, @RequestParam Integer size) {
		if(customer == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}	
		if(StringTool.isSpace(customer) || customer.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白,搜尋全部");
			return recordService.getAllRentalRecord(page, size);
		}
		return recordService.getRentalRecordByCustomer(customer, page, size);
	}
	
	// 新增租借紀錄
	// 權限
	@PostMapping(value = "/rental")
	public String addRental(@RequestBody Rental rental) {
		if(rental == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		// 加資料(物件)檢查程序
		recordService.addRental(rental);
		return "";
	}
	
	// 編輯租借紀錄共用fun
	// 權限
	@PutMapping(value = "/rental")
	public String updateRental(@RequestBody Rental rental) {
		if(rental == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		// 加資料(物件)檢查程序
		recordService.updateRental(rental);
		return "";
	}
	
	// 搜尋付款紀錄
	@PostMapping(value = "/payment/search")
	public List<Payment> getPaymentByCustomer(@RequestParam String customer,
			@RequestParam Integer page, @RequestParam Integer size) {
		if(customer == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(customer) || customer.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白,搜尋全部");
			return recordService.getAllPaymentRecord(page, size);
		}
		return recordService.getPaymentRecordByCustomer(customer, page, size);
		
	}
	
	// 搜尋付款紀錄
	// 區間
	// 分頁批量
	@PostMapping(value = "/payment/date")
	public List<Payment> getPaymentByDate(@RequestParam String startTime, @RequestParam String endTime, 
			@RequestParam Integer page, @RequestParam Integer size) {
		if(startTime == null || endTime == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(startTime) || startTime.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("開始時間參數為空白,回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(endTime) || endTime.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("結束時間參數為空白,複寫現在時間");
			endTime = StringTool.getSystemTime();
		}
		return recordService.getPaymentRecordByDate(startTime, endTime, page, size);
	}
	
	// 新增付款紀錄
	// 權限
	@PostMapping(value = "/payment")
	public String addPayment(@RequestBody Payment payment) {
		if(payment == null) {
			// 參數null 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		// 加資料(物件)檢查程序
		recordService.addPayment(payment);
		return "";
	}
	
//	// 編輯付款紀錄
//	// 權限
//	// ???
//	@PutMapping(value = "/payment")
//	public String updatePayment(@RequestBody Payment payment) {
//		return "";
//	}
}
