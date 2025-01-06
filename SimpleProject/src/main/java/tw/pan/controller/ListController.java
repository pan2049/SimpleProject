package tw.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.pan.entity.Customer;
import tw.pan.entity.Film;
import tw.pan.service.ListService;
import tw.pan.utils.StringTool;

@RestController
@RequestMapping(value = "/index/api")
@CrossOrigin
public class ListController {
	
	@Autowired
	private ListService listService;

	// 搜尋電影
	// 模糊搜尋
	@GetMapping(value = "/film/search")
	public List<Film> getFilmSearch(@RequestParam String text) {
		if(text == null) {
			// 參數null or "" 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(text) || text.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白,搜尋全部");
			return listService.getAllFilm();
		}
		if(StringTool.hasTextAndSpace(text)) {
			// 單一搜尋
			System.out.println("單一搜尋");
			return listService.getFilmFuzzyQuery(text);
		}else {
			// 多條件搜尋
			System.out.println("多條件搜尋");
			return listService.getFilmFuzzyQuery(StringTool.cutString(text));
		}
		
	}

	// 搜尋電影
	// ?作法
	@GetMapping(value = "/film/actor/{actor}")
	public List<Film> getFilmByActor(@PathVariable String actor) {
		if(actor == null) {
			// 參數null or "" 回傳錯誤
			System.out.println("參數null 回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(actor) || actor.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白回傳錯誤");
			return null;
		}
		return listService.getFilmByActor(actor);
	}
	
	// 搜尋電影
	// 不同做法 {}作法
	@GetMapping(value = "/film/category/{category}")
	public List<Film> getFilmByCategory(@PathVariable String category) {
		if(category == null) {
			// 參數null or "" 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(category) || category.equals("")) {
			// 參數為空白,搜尋全部
			System.out.println("參數為空白回傳錯誤");
			return null;
		}
		return listService.getFilmByCategory(category);
	}
	
	// 搜尋客戶資料
	// 加權限
	@GetMapping(value = "/customer/search")
	public List<Customer> getCustomerByName(@RequestParam String name) {
		if(name == null) {
			// 參數null or "" 回傳錯誤
			System.out.println("參數null回傳錯誤");
			return null;
		}
		if(StringTool.isSpace(name) || name.equals("")) {
			// 參數為空白,搜尋全部
			return listService.getAllCustomer();
		}
//		return listService.getAllCustomer(name);
		return null;
	}
	
	// 取得庫存資料
	// 加權限
	@PostMapping(value = "/inventory")
	public String getInventoryByFilmAndStore() {
		return "";
	}
	
	// 新增會員
	// 加權限
	@PostMapping(value = "/customer")
	public String addCustomer() {
		return "";
	}
	
	// 刪除會員
	// 加權限
	@DeleteMapping(value = "/customer")
	public String deleteCustomer() {
		return "";
	}
	
	
}
