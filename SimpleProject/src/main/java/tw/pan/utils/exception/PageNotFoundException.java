package tw.pan.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "page not found")
public class PageNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
