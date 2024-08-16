package controller;

import model.Lotto;
import model.LottoResult;
import model.Lottos;
import model.WinningLotto;
import service.LottoService;
import utils.handler.InputHandler;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int price = InputHandler.handleInput(InputView::inputLottoPrice);
        Lottos lottos = lottoService.generateLottos(price);
        OutputView.printLottos(lottos);

        Lotto winningLottoNumbers = InputHandler.handleInput(InputView::inputWinningNumbers);
        int bonusNumber = InputHandler.handleInput(() -> InputView.inputBonusNumber(winningLottoNumbers));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winningLotto);
        OutputView.printLottoResult(lottoResult);

        double yield = lottoService.calculateYield(lottoResult, price);
        OutputView.printYield(yield);
    }


}
