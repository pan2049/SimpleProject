package tw.pan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.pan.entity.po.Film;
import tw.pan.service.ListService;
import tw.pan.utils.StringTool;
import tw.pan.utils.exception.RequestErrorException;

@RestController
@RequestMapping(value = "/index/api")
@CrossOrigin
public class CustomerController {

	@Autowired
	private ListService listService;

	// 搜尋電影
	// 模糊搜尋
	@GetMapping(value = "/film/search")
	public ResponseEntity<List<Film>> getFilmSearch(@RequestParam String text) throws RequestErrorException {
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
	public ResponseEntity<List<Film>> getFilmByActor(@PathVariable String actor) throws RequestErrorException {
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
	public ResponseEntity<List<Film>> getFilmByCategory(@PathVariable String category) throws RequestErrorException {
		if(category == null) {
			throw new RequestErrorException("request param is null");
		}
		if(StringTool.isSpace(category) || category.equals("")) {
			throw new RequestErrorException("request param has space");	
		}
		return ResponseEntity.ok(listService.getFilmByCategory(category));
	}
}
