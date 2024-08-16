package utils.enums;

public enum IOMessage {
    INPUT_LOTTO_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;
    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
