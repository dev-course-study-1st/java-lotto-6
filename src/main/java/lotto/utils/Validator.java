package lotto.utils;

import lotto.utils.constant.Numbers;

import java.util.regex.Pattern;

import static lotto.utils.constant.Errors.CANNOT_DIV_BY_UNIT_PRICE_ERROR_MSG;
import static lotto.utils.constant.Errors.ONLY_CONTAIN_NUMBERS_ERROR_MSG;
import static lotto.utils.constant.Strings.ONLY_NUMBER_REGEX;

public class Validator {

    public static void isComposedNumber(String input) {
        if(!isMatchesOnlyNumber(input)) {
            throw new IllegalArgumentException(ONLY_CONTAIN_NUMBERS_ERROR_MSG.toString());
        }
    }

    public static boolean isMatchesOnlyNumber(String input) {
        return Pattern.matches(ONLY_NUMBER_REGEX.toString(), input);
    }

    public static void isPriceDivisible(int price) {
        if(price % Numbers.LOTTO_UNIT_PRICE.getValue() != Numbers.ZERO.getValue()) {
            throw new IllegalArgumentException(CANNOT_DIV_BY_UNIT_PRICE_ERROR_MSG.toString());
        }
    }
}
