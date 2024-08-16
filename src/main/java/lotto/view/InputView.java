package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Price;

import static lotto.utils.constant.Strings.*;

public class InputView {

    public static Price inputPriceToBuyLotto() {
        System.out.println(INPUT_PRICE_TO_BUY_MSG);
        return new Price(Console.readLine());
    }
}
