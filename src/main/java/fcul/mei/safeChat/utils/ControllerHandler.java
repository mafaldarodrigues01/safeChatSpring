package fcul.mei.safeChat.utils;

import java.util.function.Supplier;

public class ControllerHandler {
    public static <T> void handleException(Supplier<T> function) {
        try {
            function.get();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }



}
