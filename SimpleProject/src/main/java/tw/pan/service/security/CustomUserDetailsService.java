//package tw.pan.service.security;
//
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if (username != null && username.equals("user")) {
//			return new User(username, "{noop}user",
//					AuthorityUtils.commaSeparatedStringToAuthorityList("S"));
//		} else {
//			throw new UsernameNotFoundException("No Such Account Found");
//		}
//	}
//
//	
//}
