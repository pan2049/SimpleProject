package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.pan.entity.Address;
import tw.pan.entity.Customer;
import tw.pan.entity.Film;
import tw.pan.entity.Inventory;
import tw.pan.entity.Store;
import tw.pan.mappers.AddressDao;
import tw.pan.mappers.CustomerDao;
import tw.pan.mappers.FilmDao;
import tw.pan.mappers.InventoryDao;
import tw.pan.mappers.StoreDao;

@Service
public class ListService {

	@Autowired
	private FilmDao filmDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private AddressDao addressDao;
	
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
	
	@Cacheable(value = "customerSearchCache", key = "'all'")
	public List<Customer> getAllCustomer() {
		return customerDao.selectAllCustomer();
	}
	
	public List<Customer> getCustomerByName(String name) {
		return customerDao.selectCustomerByName(name);
	}
	
	public Boolean checkStore(Integer storeId) {
		Store result = storeDao.selectStoreById(storeId);
		if(result != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Inventory> getAllInventory() {
		return inventoryDao.selectAllInventory();
	}
	
	public List<Inventory> getInventoryByFilm(String name) {
		return inventoryDao.selectInventoryByFilm(name);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void createCustomer(Customer customer) {
		addressDao.insertAddress(customer.getAddress());
		Integer lastId = addressDao.selectLastInsertId();
		customer.getAddress().setAddressId(lastId);
		customerDao.insertCustomer(customer);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deleteCutomerAndAddress(Integer cutomerId) {
		Customer cutomer = customerDao.selectCustomerById(cutomerId);
		if(cutomer != null) {
			customerDao.deleteCustomerById(cutomerId);
			addressDao.deleteAddress(cutomer.getAddress().getAddressId());
		}else {
			// 資料錯誤
		}
		
	}
}
