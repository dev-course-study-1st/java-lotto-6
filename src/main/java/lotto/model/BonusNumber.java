package lotto.model;

import lotto.utils.constant.ErrorMessage;
import lotto.utils.constant.LottoGameNumber;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateBonusNumberInRange(number);
        this.number = number;
    }

    private void validateBonusNumberInRange(int number) {
        if (number < LottoGameNumber.LOTTO_RANDOM_MIN_NUMBER.getNumber() || number > LottoGameNumber.LOTTO_RANDOM_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_IN_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

}
