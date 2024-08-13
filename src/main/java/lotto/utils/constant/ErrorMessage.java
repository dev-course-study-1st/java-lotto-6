package lotto.utils.constant;

public enum ErrorMessage {
    INVALID_NUMBER_DUPLICATION("로또 번호는 중복될 수 없습니다."),
    INVALID_INTEGER_TYPE("구입 금액이 정수가 아닙니다."),
    INVALID_NUMBER_IN_RANGE("로또 번호는 1부터 45까지의 숫자만 가능합니다."),
    INVALID_MIN_MONEY("로또 금액은 1000원 이상이어야 합니다."),
    INVALID_MONEY_UNIT("로또 금액은 1000원 단위여야 합니다."),
    INVALID_BONUS_NUMBER_IN_RANGE("보너스 번호는 1부터 45까지의 숫자만 가능합니다."),
    INVALID_DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_INPUT("당첨 번호 입력은 숫자와 쉼표(,)만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
