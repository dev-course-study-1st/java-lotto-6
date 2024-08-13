package lotto.util;

import java.util.List;
import lotto.domain.Lotto;

public class StringUtil {

    private static final String LOTTO_NUMBERS_FORMAT = "[%s]";
    private static final String DELIMITER = ", ";

    private StringUtil() { }

    public static String formatLottoNumbers(Lotto lotto) {
        List<String> numbers = lotto.getNumbers()
                .stream().map(String::valueOf)
                .toList();
        return String.format(LOTTO_NUMBERS_FORMAT, String.join(DELIMITER, numbers));
    }
}
