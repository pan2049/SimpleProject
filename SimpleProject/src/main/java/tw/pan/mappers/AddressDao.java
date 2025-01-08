package tw.pan.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import tw.pan.entity.Address;

public interface AddressDao {

	@Insert("INSERT INTO sakila.address (`address`, `address2`, `district`, `city_id`, `postal_code`, `phone`) \r\n"
			+ "VALUES (#{address}, #{address2}, #{district}, #{city.cityId}, #{postalCode}, #{phone})")
	public void insertAddress(Address address);
	
	@Select("SELECT LAST_INSERT_ID()")
	public Integer selectLastInsertId();
	
	@Delete("DELETE FROM sakila.address WHERE `address_id` = #{addressId}")
	public void deleteAddress(Integer addressId);
}
