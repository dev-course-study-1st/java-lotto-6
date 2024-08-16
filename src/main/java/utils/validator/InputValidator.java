package utils.validator;

import model.Lotto;
import model.WinningLotto;
import utils.enums.ConstantNumber;
import utils.enums.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private InputValidator() {
    }

    public static Integer validateLottoPrice(String input) {
        return validatePriceUnit(NumberValidator.validateNumber(input));
    }

    public static List<Integer> validateLottoNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(NumberValidator::validateNumber)
                .peek(NumberValidator::validateNumberInRange)
                .toList();
        validateNoDuplicate(numbers);
        return numbers;
    }

    public static WinningLotto validateBonusNumber(String input, Lotto lotto) {
        Integer bonusNumber = NumberValidator.validateNumber(input);
        NumberValidator.validateNumberInRange(bonusNumber);
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
        }
        return new WinningLotto(lotto, bonusNumber);
    }

    private static Integer validatePriceUnit(Integer price) {
        if (price % ConstantNumber.LOTTO_PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.toString());
        }
        return price;
    }

    private static void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
        }
    }

}
