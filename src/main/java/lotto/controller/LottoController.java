package lotto.controller;

import lotto.exception.InvalidIntegerTypeException;
import lotto.model.*;
import lotto.service.LottoService;
import lotto.utils.constant.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Player player = createLotto();
        WinningLotto winningLotto = createWinningLotto();
        LottoResult lottoResult = lottoService.calculateLottoResult(player, winningLotto);
        OutputView.printLottoResult(lottoResult);
        OutputView.printLottoRateOfReturn(lottoResult.calculateRateOfReturn(player.getBudget().getBudget()));
    }

    public Player createLotto() {
        try {
            Player player = lottoService.purchaseLotto(InputView.inputPurchaseMoney());
            OutputView.printLottoCount(player);
            OutputView.printLottos(player.getLottos());
            return player;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return createLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLotto();
        }
    }

    public WinningLotto createWinningLotto() {
        WinningNumbers winningNumbers = createWinningNumbers();
        BonusNumber bonusNumber = createBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private WinningNumbers createWinningNumbers() {
        try {
            return new WinningNumbers(InputView.inputWinningNumbers());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return createWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private BonusNumber createBonusNumber() {
        try {
            return new BonusNumber(InputView.inputBonusNumber());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return createBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
        }
    }
}
