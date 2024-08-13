package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;
import lotto.utils.constant.ErrorMessage;
import lotto.utils.constant.GameMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputPurchaseMoney() {
        try {
            System.out.println(GameMessage.INPUT_MONEY.getMessage());
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return inputPurchaseMoney();
        }
    }

    private static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            System.out.println(GameMessage.INPUT_WINNING_NUMBER.getMessage());
            String InputWinningNumber = Console.readLine();
            InputValidator.validateWinningNumberInput(InputWinningNumber);
            return parseNumbers(InputWinningNumber);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            System.out.println(GameMessage.INPUT_BONUS_NUMBER.getMessage());
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_INTEGER_TYPE.getMessage());
            return inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_NUMBER_IN_RANGE.getMessage());
            return inputBonusNumber();
        }
    }

}
