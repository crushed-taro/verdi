package verdi_server.exception;

public class LoginFailedException extends RuntimeException{

    public LoginFailedException(String message) {
        super(message);
    }
}
