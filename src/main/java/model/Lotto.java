package model;

import utils.enums.ErrorMessage;

import java.util.List;

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
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
