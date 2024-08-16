package controller;

import lotto.Lotto;
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
        int bonusNumber = InputView.inputBonusNumbers(lotto);
    }
}
