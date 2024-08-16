package lotto.model;

import static lotto.utils.constant.Errors.*;

import lotto.utils.Validator;
import lotto.utils.constant.Numbers;

import java.util.regex.Pattern;


import static lotto.utils.constant.Strings.*;

public class Price {
    private int price;

    public Price(String inputPrice) {
        this.price = validate(inputPrice);
    }

    private int validate(String inputPrice) {
        Validator.isComposedNumber(inputPrice);
        int price = Integer.parseInt(inputPrice);
        Validator.isPriceDivisible(price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}
