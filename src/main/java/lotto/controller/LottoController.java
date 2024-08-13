package lotto.controller;

import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Ranking;
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
        LottoResult lottoResult = lottoService.calculateLotto(winningLotto, lottoBundle);
        Map<Ranking, Integer> value = lottoResult.value();
        for (Ranking ranking : value.keySet()) {
            System.out.println("ranking = " + ranking + ", count = " + value.get(ranking));
        }
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
