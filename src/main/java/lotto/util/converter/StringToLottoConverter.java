package lotto.util.converter;

import static lotto.util.Const.END_INCLUSIVE;
import static lotto.util.Const.START_INCLUSIVE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.Lotto;

public class StringToLottoConverter implements Converter<String, Lotto> {

    private static final String DELIMITER = ",";
    private static final String REGEX = "^[0-9,]+$";
    private final Pattern pattern = Pattern.compile(REGEX);


    @Override
    public boolean supports(Object from, Class<Lotto> to) {
        return from.getClass() == String.class && to == Lotto.class;
    }

    @Override
    public Lotto convert(String source) {
        checkForm(source);
        List<Integer> numbers = toIntegerList(source);
        checkRange(numbers);
        return new Lotto(numbers);
    }

    private void checkForm(String source) {
        if (!pattern.matcher(source).matches()) {
            throw new IllegalArgumentException("당첨번호는 숫자와 쉼표(,)로만 나타내 주세요.");
        }
    }

    private List<Integer> toIntegerList(String source) {
        String[] splitNumbers = source.split(DELIMITER);
        return Arrays.stream(splitNumbers)
                .map(this::toInt)
                .sorted()
                .toList();
    }

    private Integer toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > END_INCLUSIVE.getValue() || number < START_INCLUSIVE.getValue()) {
                throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해 주세요.");
            }
        }
    }
}
