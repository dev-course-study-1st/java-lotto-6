package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputViewProxy;

public class LottoController {

    public void run() {
        Money money = InputViewProxy.getMoney();
        System.out.println(money.value());
    }

}
