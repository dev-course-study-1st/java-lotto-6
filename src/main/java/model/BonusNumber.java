package model;

import utils.enums.ConstantNumber;
import utils.enums.ErrorMessage;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < ConstantNumber.LOTTO_NUMBER_MIN.getNumber() || number > ConstantNumber.LOTTO_NUMBER_MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
        }
    }

}
