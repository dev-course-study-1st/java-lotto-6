package lotto.utils.constant;

public enum Strings {
    INPUT_PRICE_TO_BUY_MSG("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MSG("보너스 번호를 입력해 주세요."),

    WINNING_STATISTICS_MSG("당첨 통계\n"),
    SLASH("---\n"),
    MATCH_THREE_MSG("3개 일치 (5,000원) - "),
    MATCH_FOUR_MSG("4개 일치 (50,000원) - "),
    MATCH_FIVE_MSG("5개 일치 (1,500,000원) - "),
    MATCH_SIX_WITH_BONUS_MSG("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_SIX_MSG("6개 일치 (2,000,000,000원) - "),

    COUNT_MSG("개\n"),

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
