package utils.enums;

public enum IOMessage {
    INPUT_LOTTO_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_PURCHASE("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n---"),
    LOTTO_RANK_RESULT("%d개 일치 (%s원) - %d개"),
    LOTTO_RANK_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_YIELD("총 수익률은 %.1f%%입니다.");
    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
