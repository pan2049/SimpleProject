package tw.pan.service.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.pan.entity.dto.AccessDto;

@Service
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		ResponseEntity<AccessDto> responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.contentType(MediaType.APPLICATION_JSON).body(
						new AccessDto()
						.setSuccess(false));
		response.setCharacterEncoding("UTF-8");
		response.setStatus(responseEntity.getStatusCode().value());
		response.setContentType(responseEntity.getHeaders().getContentType().toString());
		response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity.getBody()));
	}

}
