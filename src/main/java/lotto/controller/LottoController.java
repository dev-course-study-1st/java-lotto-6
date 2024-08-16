package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Result;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() throws IllegalArgumentException {
        Price price = InputView.inputPriceToBuyLotto();
        Lottos lottos = lottoService.buyLotto(price);
        OutputView.printBuyLottos(lottos);

        WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        Result result = lottoService.getWinningResult(lottos, winningNumbers);
        double returnRate = lottoService.getReturnRate(price, result.getTotalPrize());
        OutputView.printResultAndResultRate(result, returnRate);
    }
}
