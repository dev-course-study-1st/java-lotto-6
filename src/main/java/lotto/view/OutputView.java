package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public static void printBuyLottos(Lottos lottos) {
        System.out.println(lottos);
//        for(Lotto lotto : lottos.getLottoList()) {
//            System.out.println(lotto);
//        }
    }
}
