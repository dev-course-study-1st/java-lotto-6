package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Price;
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
    }
}
