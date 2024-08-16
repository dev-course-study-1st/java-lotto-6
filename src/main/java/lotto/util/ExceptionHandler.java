package lotto.util;

import java.util.function.Supplier;
import lotto.view.ErrorView;

public class ExceptionHandler {

    private ExceptionHandler() { }

    public static <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return handle(supplier);
        }
    }
}