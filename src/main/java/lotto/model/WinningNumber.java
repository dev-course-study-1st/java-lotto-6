package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final BonusNumber bonusNumber;

    public WinningNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }



}
