package lotto.model;

import lotto.utils.Validator;
import lotto.utils.constant.Strings;

import java.util.regex.Pattern;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String input) {
        this.bonusNumber = validate(input);
    }

    private int validate(String input) {
        Validator.isComposedNumber(input);
        return Integer.parseInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
