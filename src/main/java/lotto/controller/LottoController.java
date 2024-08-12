package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputViewProxy;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = InputViewProxy.getMoney();
        LottoBundle lottoBundle = lottoService.buyLotto(money);
    }

}
