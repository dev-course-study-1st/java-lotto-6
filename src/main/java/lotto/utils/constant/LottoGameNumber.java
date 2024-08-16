package lotto.utils.constant;

public enum LottoGameNumber {
    LOTTO_NUMBER_SIZE(6),
    LOTTO_RANDOM_MIN_NUMBER(1),
    LOTTO_RANDOM_MAX_NUMBER(45),
    LOTTO_GAME_PRICE(1000);

    private final int number;

    LottoGameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
