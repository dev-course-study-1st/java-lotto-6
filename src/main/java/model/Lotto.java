package model;

import utils.enums.ConstantNumber;
import utils.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.toString());
        }
        validateNumbersInRange(numbers);
        validateNoDuplicate(numbers);
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < ConstantNumber.LOTTO_NUMBER_MIN.getNumber() || number > ConstantNumber.LOTTO_NUMBER_MAX.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
