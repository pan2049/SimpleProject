package tw.pan.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "database operate error")
public class DatabaseOperateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
