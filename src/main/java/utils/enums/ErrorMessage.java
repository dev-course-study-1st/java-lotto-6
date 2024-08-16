package utils.enums;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 숫자를 입력해주세요"),
    INVALID_UNIT("[ERROR] 1000원 단위로 입력해주세요"),
    INVALID_RANGE("[ERRPR] 1 ~ 45 사이의 숫자만 입력해주세요"),
    DUPLICATE_NUMBER("[ERROR] 중복되지 않는 숫자들만 입력해주세요"),;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
