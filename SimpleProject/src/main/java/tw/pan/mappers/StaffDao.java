package tw.pan.mappers;

import java.util.List;

import tw.pan.entity.po.Staff;

public interface StaffDao {

	public List<Staff> selectAllStaff();
	
	public Staff selectStaffByUsername(String username);
}
