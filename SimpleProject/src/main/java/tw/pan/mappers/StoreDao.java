package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.po.Store;

public interface StoreDao {

	public List<Store> selectAllStore();
	
	public Store selectStoreById(Integer storeId);
}
