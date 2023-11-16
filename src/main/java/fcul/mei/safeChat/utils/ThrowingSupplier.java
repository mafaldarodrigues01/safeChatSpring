package fcul.mei.safeChat.utils;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
