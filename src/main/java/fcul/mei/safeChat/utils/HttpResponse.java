package fcul.mei.safeChat.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HttpResponse {

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User Not Found")
    public static class UserNotFound extends Exception {
        public UserNotFound() {
            super("User Not Found");
        }
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input")
    public static class InvalidInput extends Exception {
        public InvalidInput() {
            super("Invalid input");
        }
    }


}
