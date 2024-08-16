package controller;

import model.Lotto;
import model.LottoResult;
import model.Lottos;
import model.WinningLotto;
import service.LottoService;
import view.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }
    public void run(){
        int price = InputView.inputLottoPrice();
        Lotto lotto = InputView.inputWinningNumbers();
        WinningLotto winningLotto = InputView.inputBonusNumbers(lotto);
        Lottos lottos = lottoService.generateLottos(price);
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winningLotto);
        double yield = lottoService.calculateYield(lottoResult, price);
        
    }
}
