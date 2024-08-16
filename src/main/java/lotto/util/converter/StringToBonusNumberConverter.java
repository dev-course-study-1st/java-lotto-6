package lotto.util.converter;

import static lotto.util.Const.END_INCLUSIVE;
import static lotto.util.Const.START_INCLUSIVE;

import java.util.regex.Pattern;
import lotto.domain.BonusNumber;

public class StringToBonusNumberConverter implements Converter<String, BonusNumber> {

    private static final String REGEX = "^[1-9]+$";
    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public boolean supports(Object from, Class<BonusNumber> to) {
        return from.getClass() == String.class && to == BonusNumber.class;
    }

    @Override
    public BonusNumber convert(String source) {
        checkNumeric(source);
        int bonusNumber = toInt(source);
        checkRange(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private void checkNumeric(String source) {
        if (!pattern.matcher(source).matches()) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 가능합니다.");
        }
    }

    private int toInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호에는 숫자만 입력 가능합니다.");
        }
    }

    private void checkRange(Integer number) {
        if (number > END_INCLUSIVE.getValue() || number < START_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해 주세요.");
        }
    }
}
