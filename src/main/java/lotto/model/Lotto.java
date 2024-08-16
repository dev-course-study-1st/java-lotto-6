package lotto.model;

import lotto.utils.constant.Numbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Numbers.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Result compare(WinningNumber winningNumber) {
        Result result = new Result();
        return result;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
