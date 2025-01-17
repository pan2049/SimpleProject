package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.po.Inventory;

public interface InventoryDao {

	public List<Inventory> selectAllInventory();
	
	public List<Inventory> selectInventoryByFilm(String name);
	
}
