package fcul.mei.safeChat.utils;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public class ControllerHandler {
    public static <T> ResponseEntity<T> handleException(Supplier<T> function, HttpStatusCode code) {
        try {
            return new ResponseEntity<>(function.get(), code);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }



}
