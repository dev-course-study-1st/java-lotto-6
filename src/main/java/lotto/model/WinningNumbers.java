package lotto.model;

import lotto.utils.Validator;

import java.util.List;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        Validator.validateDuplicate(winningNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }



    public int getMatchCount(Lotto lotto) {
        int count = 0;
        List<Integer> numbers = winningNumber.getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if(numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
