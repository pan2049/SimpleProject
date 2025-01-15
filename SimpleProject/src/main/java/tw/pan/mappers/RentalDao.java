package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.dto.InsertRentalDto;
import tw.pan.entity.dto.UpdateRentalDto;
import tw.pan.entity.po.Rental;

public interface RentalDao {

	public List<Rental> selectAllRental(Integer page, Integer size);
	
	public List<Rental> selectRentalByCustomer(String name, Integer page, Integer size);
	
	public void insertRental(InsertRentalDto rentalDto);
	
	public void updateRental(UpdateRentalDto rentalDto);
}
