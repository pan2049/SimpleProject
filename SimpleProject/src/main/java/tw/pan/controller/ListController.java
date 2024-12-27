package tw.pan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ListController {

	// 搜尋電影
	// 模糊搜尋
	@GetMapping(value = "/get/film/search/{text}")
	public String getFilmSearch() {
		return "";
	}
	
	// 搜尋電影
	// ?作法
	@GetMapping(value = "/get/film/byActor")
	public String getFilmByActor() {
		return "";
	}
	
	// 搜尋電影
	// 不同做法 {}作法
	@GetMapping(value = "/get/film/byCategory/{category}")
	public String getFilmByCategory() {
		return "";
	}
	
	// 搜尋客戶資料
	// 加權限
	@GetMapping(value = "/get/customer/byName/{name}")
	public String getCustomerByName() {
		return "";
	}
	
	// 取得庫存資料
	// 加權限
	@PostMapping(value = "/post/inventory/byFilmAndStore")
	public String getInventoryByFilmAndStore() {
		return "";
	}
	
	// 新增會員
	// 加權限
	@PutMapping(value = "/put/customer")
	public String addCustomer() {
		return "";
	}
	
	// 刪除會員
	// 加權限
	@DeleteMapping(value = "/delete/customer")
	public String deleteCustomer() {
		return "";
	}
	
	
	
	
}
