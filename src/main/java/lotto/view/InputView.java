package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Price;

public class InputView {

    public static Price inputPriceToBuyLotto() {

        return new Price(Console.readLine());
    }
}
