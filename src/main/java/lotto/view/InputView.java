package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.converter.ConverterHolder;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() { }

    public static Money getMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, Money.class);
    }

    public static Lotto getLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        String input = Console.readLine();
        return ConverterHolder.convert(input, Lotto.class);
    }

    public static BonusNumber getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return ConverterHolder.convert(input, BonusNumber.class);
    }
}
