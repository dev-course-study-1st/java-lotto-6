package lotto.model;

import lotto.utils.constant.ErrorMessage;

import java.util.List;

public class WinningLotto {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.containsNumber(bonusNumber.getNumber());
    }

    public LottoRank matchLotto(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        return LottoRank.valueOf((int) matchCount, matchBonusNumber(lotto));
    }


}
