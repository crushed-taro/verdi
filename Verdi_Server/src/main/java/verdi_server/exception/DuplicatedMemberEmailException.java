package verdi_server.exception;

public class DuplicatedMemberEmailException extends RuntimeException{
    public DuplicatedMemberEmailException(String message) {
        super(message);
    }
}
