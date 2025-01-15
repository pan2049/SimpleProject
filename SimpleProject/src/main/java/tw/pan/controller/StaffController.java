package tw.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tw.pan.entity.dto.CustomerDto;
import tw.pan.entity.dto.InsertRentalDto;
import tw.pan.entity.dto.PaymentDto;
import tw.pan.entity.dto.UpdateRentalDto;
import tw.pan.entity.po.Customer;
import tw.pan.entity.po.Inventory;
import tw.pan.entity.po.Payment;
import tw.pan.entity.po.Rental;
import tw.pan.service.ListService;
import tw.pan.service.RecordService;
import tw.pan.service.security.JwtService;
import tw.pan.utils.StringTool;
import tw.pan.utils.exception.DatabaseOperateException;
import tw.pan.utils.exception.RequestErrorException;

@RestController
@RequestMapping(value = "/staff/api")
@CrossOrigin
public class StaffController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private ListService listService;
	@Autowired
	private RecordService recordService;
	
	// 搜尋客戶資料
	// 加權限
	@GetMapping(value = "/customer/search")
	public ResponseEntity<List<Customer>> getCustomerByName(@RequestHeader("Authorization") String token, 
			@RequestParam String name) throws RequestErrorException {
		jwtService.verifyToken(token);
		if(name == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(name) || name.equals("")) {
			return ResponseEntity.ok(listService.getAllCustomer());
		}
		return ResponseEntity.ok(listService.getCustomerByName(name));
	}
	
	// 取得庫存資料
	// 加權限
	@PostMapping(value = "/inventory/search")
	public ResponseEntity<List<Inventory>> getInventoryByFilm(@RequestHeader("Authorization") String token, 
			@RequestParam String film) throws RequestErrorException {
		jwtService.verifyToken(token);
		if(film == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(film) || film.equals("")) {
			return ResponseEntity.ok(listService.getAllInventory());
		}else {
			return ResponseEntity.ok(listService.getInventoryByFilm(film));
		}
	}
	
	// 新增會員
	// 加權限
	@PostMapping(value = "/customer")
	public ResponseEntity<String> addCustomer(@RequestHeader("Authorization") String token, 
			@Valid @RequestBody CustomerDto customerDto) throws RequestErrorException {
		jwtService.verifyToken(token);
		if(customerDto == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		listService.addCustomer(customerDto);
		return ResponseEntity.ok("add customer success !!!");
	}
	
	// 刪除會員
	// 加權限
	@DeleteMapping(value = "/customer")
	public ResponseEntity<String> deleltCustomer(@RequestHeader("Authorization") String token, @RequestParam Integer id) 
			throws RequestErrorException, DatabaseOperateException {
		jwtService.verifyToken(token);
		if(id == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		listService.deleteCustomerAndAddress(id);
		return ResponseEntity.ok("deleted customer");
	}
	
	// 搜尋租借紀錄
	@GetMapping(value = "/rental/search")
	public ResponseEntity<List<Rental>> getRentalByCustomer(@RequestHeader("Authorization") String token, @RequestParam String customer, 
			@RequestParam Integer page, @RequestParam Integer size) throws RequestErrorException{
		jwtService.verifyToken(token);
		if(customer == null) {
			throw new RequestErrorException("request param is null");
		}	
		if(StringTool.isSpace(customer) || customer.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白,搜尋全部");
			return ResponseEntity.ok(recordService.getAllRentalRecord(page, size));
		}
		return ResponseEntity.ok(recordService.getRentalRecordByCustomer(customer, page, size));
	}
	
	// 新增租借紀錄
	// 權限
	@PostMapping(value = "/rental")
	public ResponseEntity<String> addRental(@RequestHeader("Authorization") String token, @Valid @RequestBody InsertRentalDto rentalDto) 
			throws RequestErrorException {
		jwtService.verifyToken(token);
		if(rentalDto == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		recordService.addRental(rentalDto);
		return ResponseEntity.ok("add rental successs !!!");
	}
	
	// 編輯租借紀錄共用fun
	// 權限
	@PutMapping(value = "/rental")
	public ResponseEntity<String> updateRental(@RequestHeader("Authorization") String token, @Valid @RequestBody UpdateRentalDto rentalDto) 
			throws RequestErrorException {
		jwtService.verifyToken(token);
		if(rentalDto == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		recordService.updateRental(rentalDto);
		return ResponseEntity.ok("edit rental record success !!!");
	}
	
	// 搜尋付款紀錄
	@PostMapping(value = "/payment/search")
	public ResponseEntity<List<Payment>> getPaymentByCustomer(@RequestHeader("Authorization") String token, @RequestParam String customer, 
			@RequestParam Integer page, @RequestParam Integer size) throws RequestErrorException {
		jwtService.verifyToken(token);
		if(customer == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(customer) || customer.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白,搜尋全部");
			return ResponseEntity.ok(recordService.getAllPaymentRecord(page, size));
		}
		return ResponseEntity.ok(recordService.getPaymentRecordByCustomer(customer, page, size));
		
	}
	
	// 搜尋付款紀錄
	// 區間
	// 分頁批量
	@PostMapping(value = "/payment/date")
	public ResponseEntity<List<Payment>> getPaymentByDate(@RequestHeader("Authorization") String token, @RequestParam String startTime, 
			@RequestParam String endTime, @RequestParam Integer page, @RequestParam Integer size) throws RequestErrorException {
		jwtService.verifyToken(token);
		if(startTime == null || endTime == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(startTime) || startTime.equals("")) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(endTime) || endTime.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("結束時間參數為空白,複寫現在時間");
			endTime = StringTool.getSystemTime();
		}
		return ResponseEntity.ok(recordService.getPaymentRecordByDate(startTime, endTime, page, size));
	}
	
	// 新增付款紀錄
	// 權限
	@PostMapping(value = "/payment")
	public ResponseEntity<String> addPayment(@RequestHeader("Authorization") String token, @Valid @RequestBody PaymentDto paymentDto) 
			throws RequestErrorException {
		jwtService.verifyToken(token);
		if(paymentDto == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		recordService.addPayment(paymentDto);
		return ResponseEntity.ok("add payment record success !!!");
	}

}
