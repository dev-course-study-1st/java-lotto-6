package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.Price;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;

import static lotto.utils.constant.Strings.*;

public class InputView {

    public static Price inputPriceToBuyLotto() {
        Price price = null;
        while(price == null) {
            try {
                System.out.println(INPUT_PRICE_TO_BUY_MSG);
                price = new Price(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public static WinningNumbers inputWinningNumbers() {
        WinningNumber winningNumber = inputNumbers();
        BonusNumber bonusNumber = inputBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private static WinningNumber inputNumbers() {
        WinningNumber winningNumber = null;
        while(winningNumber == null) {
            try {
                System.out.println(INPUT_WINNING_NUMBER_MSG);
                winningNumber = new WinningNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    private static BonusNumber inputBonusNumber() {
        BonusNumber bonusNumber = null;
        while(bonusNumber == null) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MSG);
                bonusNumber = new BonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
