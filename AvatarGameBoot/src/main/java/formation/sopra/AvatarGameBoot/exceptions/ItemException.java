package formation.sopra.AvatarGameBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "not found")
public class ItemException extends RuntimeException{

	public ItemException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ItemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ItemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ItemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
