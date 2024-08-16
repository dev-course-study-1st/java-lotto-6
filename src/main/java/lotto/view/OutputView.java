package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;

public class OutputView {

    public static void printBuyLottos(Lottos lottos) {

        System.out.println(lottos);
    }

    public static void printResultAndResultRate(Result result, double returnRate) {
        System.out.println(result);
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
