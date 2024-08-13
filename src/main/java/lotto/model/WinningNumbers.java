package lotto.model;

import java.util.List;

public class WinningNumbers extends Lotto {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
