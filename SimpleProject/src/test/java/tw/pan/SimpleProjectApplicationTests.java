package tw.pan;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.pan.entity.City;
import tw.pan.mappers.CityMapper;

@SpringBootTest	
class SimpleProjectApplicationTests {

	@Autowired
	private CityMapper cityMapper;
	
	
	@Test
	void contextLoads() {
		List<City> result = cityMapper.getCityWithCountry();
		for(City c : result) {
			System.out.println(c);
		}
	}

}
