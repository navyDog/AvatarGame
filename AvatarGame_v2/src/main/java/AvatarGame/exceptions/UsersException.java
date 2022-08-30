package AvatarGame.exceptions;

public class UsersException extends RuntimeException {
	public UsersException() {

	}

	public UsersException(String message) {
		super(message);
	}

	public UsersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
