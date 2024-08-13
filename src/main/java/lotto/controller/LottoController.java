package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.ExceptionHandler;
import lotto.view.InputViewProxy;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = InputViewProxy.getMoney();
        LottoBundle lottoBundle = lottoService.buyLotto(money);
        OutputView.printLottos(lottoBundle);
        WinningLotto winningLotto = getWinningLotto();
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = InputViewProxy.getLottoNumber();
        return ExceptionHandler.handle(() -> getBonusNumber(lotto));
    }

    private WinningLotto getBonusNumber(Lotto lotto) {
        BonusNumber bonusNumber = InputViewProxy.getBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

}
