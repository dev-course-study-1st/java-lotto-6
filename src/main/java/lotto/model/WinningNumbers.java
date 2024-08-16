package lotto.model;

import java.util.List;

public class WinningNumbers {

    private final WinningNumber numbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber numbers, BonusNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨번호: ").append(numbers.getNumbers())
                .append(", 보너스 번호: ").append(bonusNumber.getBonusNumber());
        return sb.toString();
    }
}
