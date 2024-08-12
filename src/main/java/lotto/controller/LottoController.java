package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        Money money = InputView.getMoney();
        System.out.println(money.value());
    }

}
