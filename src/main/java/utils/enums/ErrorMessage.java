package utils.enums;

public enum ErrorMessage {
    INVALID_NUMBER("숫자를 입력해주세요"),
    INVALID_UNIT("1000원 단위로 입력해주세요"),
    INVALID_RANGE("1 ~ 45 사이의 숫자만 입력해주세요"),
    INVALID_SIZE("6개의 숫자만 입력해주세요"),
    DUPLICATE_NUMBER("중복되지 않는 숫자들만 입력해주세요"),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }
}
