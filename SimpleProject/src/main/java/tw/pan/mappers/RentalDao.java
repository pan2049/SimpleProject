package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.Rental;

public interface RentalDao {

	public List<Rental> selectAllRental(Integer page, Integer size);
	
	public List<Rental> selectRentalByCustomer(String name, Integer page, Integer size);
	
	public void insertRental(Rental rental);
	
	public void updateRental(Rental rental);
}
