package slipp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginRequiredAdvice {
    private static final Logger log = LoggerFactory.getLogger(LoginRequiredAdvice.class);

    @ExceptionHandler(LoginRequiredException.class)
    public String handleConflict() {
        log.debug("LoginRequiredException is happened!");
        return "redirect:/user/login";
    }
}
