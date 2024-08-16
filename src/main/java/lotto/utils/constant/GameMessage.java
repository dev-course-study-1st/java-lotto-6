package lotto.utils.constant;

public enum GameMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    OUTPUT_PURCHASED_LOTTO_COUNT("%s개를 구매했습니다.\n"),
    OUTPUT_RESULT_STATISTICS("당첨 통계\n---"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %s%%입니다."),
    OUTPUT_LOTTO_RESULT("%s개 일치 (%s원) - %s개\n"),
    OUTPUT_LOTTO_RESULT_BONUS("%s개 일치, 보너스 볼 일치 (%s원) - %s개\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
