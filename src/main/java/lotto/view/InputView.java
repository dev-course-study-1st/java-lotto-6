package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.Price;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;

import java.util.List;

import static lotto.utils.constant.Strings.*;

public class InputView {

    public static Price inputPriceToBuyLotto() {
        System.out.println(INPUT_PRICE_TO_BUY_MSG);
        return new Price(Console.readLine());
    }

    public static WinningNumbers inputWinningNumbers() {
        WinningNumber winningNumber = inputNumbers();
        BonusNumber bonusNumber = inputBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private static WinningNumber inputNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MSG);
        return new WinningNumber(Console.readLine());
    }

    private static BonusNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
        return new BonusNumber(Console.readLine());
    }
}
