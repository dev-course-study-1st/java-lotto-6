package lotto.utils;

import lotto.utils.constant.ErrorMessage;

public class InputValidator {
    public static void validateWinningNumberInput(String input) {
        if (input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_INPUT.getMessage());
        }
    }
}
