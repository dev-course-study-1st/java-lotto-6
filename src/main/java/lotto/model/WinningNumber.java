package lotto.model;

import lotto.utils.Validator;
import lotto.utils.constant.Errors;
import lotto.utils.constant.Numbers;
import lotto.utils.constant.Strings;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(String numbers) {
        List<Integer> list = Arrays.stream(numbers.split(Strings.COMMA.toString()))
                    .filter(Validator::isMatchesOnlyNumber)
                    .mapToInt(Integer::parseInt)
                    .filter(Validator::isRangeInLottoNumber)
                    .boxed().distinct()
                    .toList();

        if(list.size() != Numbers.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(Errors.NOT_EQUAL_LOTTO_SIZE_ERROR_MSG.toString());
        }

        return list;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
