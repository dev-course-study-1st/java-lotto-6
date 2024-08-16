package lotto.utils.constant;

public enum Errors {
    ERROR("[ERROR] "),
    ONLY_CONTAIN_NUMBERS_ERROR_MSG(ERROR+"문자열이 포함될 수 없습니다."),
    PRICE_IS_ZERO_ERROR_MSG(ERROR+"가격은 최소 1000원 이상이어야 합니다."),
    CANNOT_DIV_BY_UNIT_PRICE_ERROR_MSG(ERROR+"가격은 1000원 단위로 입력해야 합니다."),
    NOT_EQUAL_LOTTO_SIZE_ERROR_MSG(ERROR+"6개의 번호가 만들어지지 않았습니다."),
    DUPLICATED_NUMBER_ERROR_MSG(ERROR+"로또번호는 중복되지 않아야합니다.");

    private final String string;

    Errors (String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
