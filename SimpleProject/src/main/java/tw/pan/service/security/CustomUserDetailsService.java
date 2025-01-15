package tw.pan.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tw.pan.entity.po.Staff;
import tw.pan.mappers.StaffDao;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null) throw new UsernameNotFoundException("request username is null");
		Staff staff = staffDao.selectStaffByUsername(username);
		if (staff != null) {
			return User.withUsername(username)
				     .password(staff.getPassword())
				     .roles("S")
				     .build();
		} else {
			throw new UsernameNotFoundException("No Such Account Found");
		}
	}

	
}
