package tw.pan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class RecordController {

	// 搜尋租借紀錄
	@PostMapping(value = "/post/rental/byCustomer")
	public String getRentalByCustomer() {
		return "";
	}
	
	// 新增租借紀錄
	// 權限
	@PostMapping(value = "/post/rental/create")
	public String addRental() {
		return "";
	}
	
	// 編輯租借紀錄共用fun
	// 權限
	@PutMapping(value = "/put/rental/update")
	public String updateRental() {
		return "";
	}
	
	// 搜尋付款紀錄
	@PostMapping(value = "/post/payment/byCustomer")
	public String getPaymentByCustomer() {
		return "";
	}
	
	// 搜尋付款紀錄
	// 區間
	// 分頁批量
	@PostMapping(value = "/post/payment/byDate")
	public String getPaymentByDate() {
		return "";
	}
	
	// 新增付款紀錄
	// 權限
	@PostMapping(value = "/post/payment/create")
	public String addPayment() {
		return "";
	}
	
	// 編輯付款紀錄
	// 權限
	// ???
	@PutMapping(value = "/put/payment/update")
	public String updatePayment() {
		return "";
	}
}
