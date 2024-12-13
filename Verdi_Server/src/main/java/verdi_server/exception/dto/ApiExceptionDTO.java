package verdi_server.exception.dto;

public class ApiExceptionDTO {
    // 예외 발생 시 프론트로 보낼 DTO

    private int status;
    private String message;

    public ApiExceptionDTO() {
    }

    public ApiExceptionDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiExceptionDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
