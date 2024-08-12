package lotto.view;

import lotto.domain.Money;
import lotto.util.ExceptionHandler;

public class InputViewProxy {

    private InputViewProxy() { }

    public static Money getMoney() {
        return ExceptionHandler.handle(InputView::getMoney);
    }

}
