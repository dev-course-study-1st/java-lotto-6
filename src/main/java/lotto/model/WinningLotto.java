package lotto.model;

import lotto.utils.constant.ErrorMessage;

import java.util.List;

public class WinningLotto extends Lotto {
    private final List<Integer> numbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, BonusNumber bonusNumber) {
        super(numbers);
        validateDuplicateBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public LottoRank matchLotto(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        return LottoRank.valueOf((int) matchCount, matchBonusNumber(lotto));
    }


}
