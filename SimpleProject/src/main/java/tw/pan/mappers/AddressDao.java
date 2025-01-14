package tw.pan.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import tw.pan.entity.dto.CustomerDto;
import tw.pan.entity.po.Address;

public interface AddressDao {

	@Insert("INSERT INTO sakila.address (`address`, `address2`, `district`, `city_id`, `postal_code`, `phone`) \r\n"
			+ "VALUES (#{address}, #{address2}, #{district}, #{cityId}, #{postalCode}, #{phone})")
	public void insertAddress(CustomerDto customerDto);
	
	@Select("SELECT LAST_INSERT_ID()")
	public Integer selectLastInsertId();
	
	@Delete("DELETE FROM sakila.address WHERE `address_id` = #{addressId}")
	public void deleteAddress(Integer addressId);
}
