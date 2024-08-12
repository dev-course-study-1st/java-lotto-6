package lotto.model;

import lotto.utils.constant.ErrorMessage;
import lotto.utils.constant.LottoGameNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSizeCorrect(List<Integer> numbers) {
        if (numbers.size() != LottoGameNumber.LOTTO_NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LottoGameNumber.LOTTO_RANDOM_MIN_NUMBER.getNumber() ||
                number > LottoGameNumber.LOTTO_RANDOM_MAX_NUMBER.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_IN_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumberInLotto(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATION.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateNumberInRange(numbers);
        validateNumberSizeCorrect(numbers);
        validateDuplicateNumberInLotto(numbers);
    }
}
