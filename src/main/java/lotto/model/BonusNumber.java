package lotto.model;

import lotto.utils.Validator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input) {
        this.bonusNumber = validate(input);
    }

    private int validate(String input) {
        Validator.isComposedNumber(input);
        int number = Integer.parseInt(input);

        Validator.validateLottoNumber(number);
        return number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
