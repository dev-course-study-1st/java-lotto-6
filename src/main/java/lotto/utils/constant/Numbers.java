package lotto.utils.constant;

public enum Numbers {
    ZERO(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    MIN(1),
    LOTTO_SIZE(6),
    MAX(45),
    LOTTO_UNIT_PRICE(1000);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
