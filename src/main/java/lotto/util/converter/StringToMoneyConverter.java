package lotto.util.converter;

import lotto.domain.Money;

public class StringToMoneyConverter implements Converter<String, Money>{

    private static final int MONEY_UNIT = 1000;

    @Override
    public boolean supports(Object from, Class<Money> to) {
        return from.getClass() == String.class && to == Money.class;
    }

    @Override
    public Money convert(String source) {
        int value = toInt(source);
        checkValue(value);
        return new Money(value);
    }

    private int toInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액에는 숫자만 입력 가능합니다.");
        }
    }

    private void checkValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
        if (value % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

}