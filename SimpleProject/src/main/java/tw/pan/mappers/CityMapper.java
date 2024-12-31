package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.City;

public interface CityMapper {

	List<City> getCityWithCountry();
	
	List<City> getCity();
}
