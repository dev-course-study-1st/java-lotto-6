package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.ExceptionHandler;

public class InputViewProxy {

    private InputViewProxy() { }

    public static Money getMoney() {
        return ExceptionHandler.handle(InputView::getMoney);
    }

    public static Lotto getLottoNumber() {
        return ExceptionHandler.handle(InputView::getLottoNumber);
    }

    public static BonusNumber getBonusNumber() {
        return ExceptionHandler.handle(InputView::getBonusNumber);
    }
}
