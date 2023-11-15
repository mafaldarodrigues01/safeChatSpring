package fcul.mei.safeChat.utils;

import java.util.function.Supplier;

public class ControllerHandler {
    public static <T> T handleException(Supplier<T> function) {
        try {
            return function.get();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }



}
