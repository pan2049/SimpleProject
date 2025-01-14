	package tw.pan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.pan.entity.dto.CustomerDto;
import tw.pan.entity.po.Address;
import tw.pan.entity.po.Customer;
import tw.pan.entity.po.Film;
import tw.pan.entity.po.Inventory;
import tw.pan.entity.po.Store;
import tw.pan.mappers.AddressDao;
import tw.pan.mappers.CustomerDao;
import tw.pan.mappers.FilmDao;
import tw.pan.mappers.InventoryDao;
import tw.pan.mappers.StoreDao;
import tw.pan.utils.exception.DatabaseOperateException;

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
	
	@Transactional(rollbackFor = DatabaseOperateException.class)
	public void addCustomer(CustomerDto customerDto) {
		addressDao.insertAddress(customerDto);
		Integer lastId = addressDao.selectLastInsertId();
		customerDto.setAddressId(lastId);
		customerDao.insertCustomer(customerDto);
	}
	
	@Transactional(rollbackFor = DatabaseOperateException.class)
	public void deleteCustomerAndAddress(Integer customerId) {
		Customer customer = customerDao.selectCustomerById(customerId);
		if(customer != null) {
			customerDao.deleteCustomerById(customerId);
			addressDao.deleteAddress(customer.getAddress().getAddressId());
		}else {
			// 資料錯誤
		}
		
	}
}
