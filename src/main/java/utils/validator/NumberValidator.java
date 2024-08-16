package utils.validator;

import utils.enums.ConstantNumber;
import utils.enums.ErrorMessage;

public class NumberValidator {

    private static final String IS_DIGIT = "^[1-9]\\d*$";

    public static Integer validateNumber(String input) {
        if (!input.matches(IS_DIGIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toString());
        }
        return Integer.parseInt(input);
    }

    public static void validateNumberInRange(Integer number) {
        if (number < ConstantNumber.LOTTO_NUMBER_MIN.getNumber() || number > ConstantNumber.LOTTO_NUMBER_MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
        }
    }

}
