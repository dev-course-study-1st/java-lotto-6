package view;

import camp.nextstep.edu.missionutils.Console;
import model.BonusNumber;
import model.Lotto;
import model.WinningLotto;
import utils.enums.IOMessage;
import utils.validator.InputValidator;

import java.util.List;


public class InputView {
    public static int inputLottoPrice() {
        System.out.println(IOMessage.INPUT_LOTTO_PRICE);
        String input = Console.readLine();
        InputValidator.validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(IOMessage.INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        List<Integer> numbers = InputValidator.validateLottoNumbers(input);
        return new Lotto(numbers);
    }

    public static BonusNumber inputBonusNumber(Lotto lotto) {
        System.out.println(IOMessage.INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return InputValidator.validateBonusNumber(input, lotto);
    }
}
