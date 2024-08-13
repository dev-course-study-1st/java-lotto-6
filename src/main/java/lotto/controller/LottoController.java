package lotto.controller;

import static lotto.view.InputViewProxy.*;
import static lotto.view.OutputView.*;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.ExceptionHandler;
import lotto.view.InputViewProxy;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = getMoney();
        LottoBundle lottoBundle = lottoService.buyLotto(money);
        printLottos(lottoBundle);
        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = lottoService.calculateLotto(winningLotto, lottoBundle);
        printResult(lottoResult);
        Profit profit = lottoService.calculateProfit(lottoResult, money);
        printProfit(profit);
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getLottoNumber();
        return ExceptionHandler.handle(() -> getBonusNumber(lotto));
    }

    private WinningLotto getBonusNumber(Lotto lotto) {
        BonusNumber bonusNumber = InputViewProxy.getBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

}
