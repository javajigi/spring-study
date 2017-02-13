package slipp.security;

public class LoginRequiredException extends Exception {
    private static final long serialVersionUID = -6518885069295165392L;

    public LoginRequiredException() {
        super();
    }

    public LoginRequiredException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginRequiredException(String message) {
        super(message);
    }

    public LoginRequiredException(Throwable cause) {
        super(cause);
    }
}
