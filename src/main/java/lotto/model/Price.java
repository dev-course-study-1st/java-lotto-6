package lotto.model;

import static lotto.utils.constant.Errors.*;
import lotto.utils.constant.Numbers;

import java.util.regex.Pattern;


import static lotto.utils.constant.Strings.*;

public class Price {
    private int price;

    public Price(String inputPrice) {
        this.price = validate(inputPrice);
    }

    public int validate(String inputPrice) {
        return isPriceDivisible(canParseToInteger(inputPrice));
    }

    private int canParseToInteger(String price) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX.toString(), price)) {
            throw new IllegalArgumentException(ONLY_CONTAIN_NUMBERS_ERROR_MSG.toString());
        }
        return Integer.parseInt(price);
    }

    private int isPriceDivisible (int price) {
        if(price % Numbers.LOTTO_UNIT_PRICE.getValue() != Numbers.ZERO.getValue()) {
            throw new IllegalArgumentException(CANNOT_DIV_BY_UNIT_PRICE_ERROR_MSG.toString());
        }
        return price;
    }

    public int getPrice() {
        return price;
    }
}
