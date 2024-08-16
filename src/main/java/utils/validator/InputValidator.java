package utils.validator;

import model.BonusNumber;
import model.Lotto;
import utils.enums.ConstantNumber;
import utils.enums.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String IS_DIGIT = "^[1-9]\\d*$";

    private InputValidator() {}

    public static int validateLottoPrice(String input) {
        return validatePriceUnit(validateNumber(input));
    }

    public static List<Integer> validateLottoNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(InputValidator::validateNumber)
                .sorted()
                .toList();
        return numbers;
    }

    public static BonusNumber validateBonusNumber(String input, Lotto lotto) {
        int bonusNumber = validateNumber(input);
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
        }
        return new BonusNumber(bonusNumber);
    }

    private static int validatePriceUnit(Integer price) {
        if (price % ConstantNumber.LOTTO_PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.toString());
        }
        return price;
    }

    private static int validateNumber(String input) {
        if (!input.matches(IS_DIGIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toString());
        }
        return Integer.parseInt(input);
    }

}
