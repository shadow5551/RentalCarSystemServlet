package by.training.nc.dev3.exception;

public class CustomGenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomGenericException() {
        super();
    }

    public CustomGenericException(String message, Throwable cause) {
        super(message,cause);
    }

    public CustomGenericException(String message) {
        super(message);
    }

    public CustomGenericException(Throwable cause) {
        super(cause);
    }

    public CustomGenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}