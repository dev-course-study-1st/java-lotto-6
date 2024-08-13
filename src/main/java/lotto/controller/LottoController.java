package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Player player = lottoService.purchaseLotto(InputView.inputPurchaseMoney());
        OutputView.printLottoCount(player);
        OutputView.printLottos(player.getLottos());
        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningNumbers(), new BonusNumber(InputView.inputBonusNumber()));
        LottoResult lottoResult = lottoService.calculateLottoResult(player, winningLotto);
        OutputView.printLottoResult(lottoResult);
        OutputView.printLottoRateOfReturn(lottoResult.calculateRateOfReturn(player.getBudget().getBudget()));
    }
}
