package lotto.model;

import lotto.utils.Validator;

public class Price {
    private final int price;

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
