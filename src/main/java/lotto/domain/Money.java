package lotto.domain;

import static lotto.util.Const.MONEY_UNIT;

public record Money(int value) {

    public int getAmount() {
        return value / MONEY_UNIT.getValue();
    }
}