package utils.enums;

public enum ConstantNumber {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_PRICE_UNIT(1000),
    ;

    private final int number;

    ConstantNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
