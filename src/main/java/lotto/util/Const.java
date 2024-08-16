package lotto.util;

public enum Const {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_SIZE(6),
    MONEY_UNIT(1000);

    private final int value;

    Const(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
