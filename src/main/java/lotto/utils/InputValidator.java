package lotto.utils;

import lotto.utils.constant.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
    public static void validateWinningNumberInput(String input) {
        Pattern pattern = Pattern.compile("^[0-9,]*$");
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_INPUT.getMessage());
        }
    }
}
