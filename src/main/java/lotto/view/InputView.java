package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.constant.GameMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputPurchaseMoney() {
        System.out.println(GameMessage.INPUT_MONEY.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> parseNumbers(String input) {
        // TODO : 입력 값이 요구하는 형식에 맞는지 검증하는 로직 추가 해야함
        //  요구하는 형식 (1, 2, 3, 4, 5, 6)
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(GameMessage.INPUT_WINNING_NUMBER.getMessage());
        String InputWinningNumber = Console.readLine();
        return parseNumbers(InputWinningNumber);
    }

    public static int inputBonusNumber() {
        System.out.println(GameMessage.INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(Console.readLine());
    }

}
