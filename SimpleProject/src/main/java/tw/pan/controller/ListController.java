package tw.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tw.pan.entity.dto.CustomerDto;
import tw.pan.entity.po.Address;
import tw.pan.entity.po.Customer;
import tw.pan.entity.po.Film;
import tw.pan.entity.po.Inventory;
import tw.pan.service.ListService;
import tw.pan.utils.StringTool;
import tw.pan.utils.exception.RequestErrorException;

@RestController
@RequestMapping(value = "/index/api")
@CrossOrigin
public class ListController {
	
	@Autowired
	private ListService listService;

	// 搜尋電影
	// 模糊搜尋
	@GetMapping(value = "/film/search")
	public ResponseEntity<List<Film>> getFilmSearch(@RequestParam String text) throws Exception {
		if(text == null) {
			throw new RequestErrorException("request param is null");			
		}
		
		if(StringTool.isSpace(text) || text.equals("")) {
			System.out.println("request param only space response all film");
			return ResponseEntity.ok(listService.getAllFilm());
		}
		
		if(StringTool.hasTextAndSpace(text)) {
			// 單一搜尋
			System.out.println("單一搜尋");
			return ResponseEntity.ok(listService.getFilmFuzzyQuery(text));
		}else {
			// 多條件搜尋
			System.out.println("多條件搜尋");
			return ResponseEntity.ok(listService.getFilmFuzzyQuery(StringTool.cutString(text)));
		}
		
	}

	// 搜尋電影
	// ?作法
	@GetMapping(value = "/film/actor/{actor}")
	public ResponseEntity<List<Film>> getFilmByActor(@PathVariable String actor) throws Exception {
		if(actor == null) {
			throw new RequestErrorException("request param is null");			
		} 
		if(StringTool.isSpace(actor) || actor.equals("")) {
			throw new RequestErrorException("request param has space");			
		} 
		return ResponseEntity.ok(listService.getFilmByActor(actor));
	}
	
	// 搜尋電影
	// 不同做法 {}作法
	@GetMapping(value = "/film/category/{category}")
	public ResponseEntity<List<Film>> getFilmByCategory(@PathVariable String category) throws Exception {
		if(category == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(category) || category.equals("")) {
			throw new RequestErrorException("request param has space");	
		}
		return ResponseEntity.ok(listService.getFilmByCategory(category));
	}
	
	// 搜尋客戶資料
	// 加權限
	@GetMapping(value = "/customer/search")
	public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) throws Exception {
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
	public ResponseEntity<List<Inventory>> getInventoryByFilm(@RequestParam String film) throws Exception {
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
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDto customerDto) throws Exception {
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
	public ResponseEntity<String> deleltCustomer(@RequestParam Integer id) throws Exception {
		if(id == null) {
			throw new RequestErrorException("request param is null");
		}
		// 加資料(物件)檢查程序
		listService.deleteCustomerAndAddress(id);
		return ResponseEntity.ok("deleted customer");
	}
	
	
}
