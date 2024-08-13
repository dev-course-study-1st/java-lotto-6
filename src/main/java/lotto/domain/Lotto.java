package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6자리 숫자를 입력해 주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.value());
    }
}
