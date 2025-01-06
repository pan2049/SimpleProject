package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import tw.pan.entity.Customer;
import tw.pan.entity.Film;
import tw.pan.mappers.CustomerDao;
import tw.pan.mappers.FilmDao;

@Service
public class ListService {

	@Autowired
	private FilmDao filmDao;
	@Autowired
	private CustomerDao customerDao;
	
	@Cacheable(value = "filmSearchCache", key = "'all'")
	public List<Film> getAllFilm() {
		return filmDao.selectAllFilm();
	}
	
	@Cacheable(value = "filmSearchCache", key = "#text")
	public List<Film> getFilmFuzzyQuery(String text) {
		System.out.println("search!!!");
		return filmDao.selectFilm(text);
	}
	
	@Cacheable(value = "filmSearchCache", key = "#texts.toString()")
	public List<Film> getFilmFuzzyQuery(List<String> texts) {
		String likeStr = "";
		for(String text : texts) {
			likeStr += "%" + text;
		}
		likeStr += "%";
		return filmDao.selectFilmByTexts(likeStr);
	}
	
	@Cacheable(value = "filmActorCache", key = "#actorFullName")
	public List<Film> getFilmByActor(String actorFullName) {
		return filmDao.selectFilmByActor(actorFullName);
	}
	
	@Cacheable(value = "filmCategoryCache", key = "#categoryName")
	public List<Film> getFilmByCategory(String categoryName) {
		return filmDao.selectFilmByCategory(categoryName);
	}
	
	public List<Customer> getAllCustomer() {
		return customerDao.selectAllCustomer();
	}
	
//	public List<Customer> getCustomerByName(String name) {
//		return customerDao.selectCustomer(name);
//	}
	
}
