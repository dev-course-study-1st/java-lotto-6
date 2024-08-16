package lotto.utils.constant;

public enum Strings {
    INPUT_PRICE_TO_BUY_MSG("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MSG("보너스 번호를 입력해 주세요."),

    COMMA(","),
    ONLY_NUMBER_REGEX("^[0-9]+$");

    private final String string;

    Strings (String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
