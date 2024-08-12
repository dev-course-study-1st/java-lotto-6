package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.util.converter.ConverterHolder;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() { }

    public static Money getMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, Money.class);
    }

}
