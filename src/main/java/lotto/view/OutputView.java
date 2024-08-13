package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.util.StringUtil;

public class OutputView {

    private static final String AMOUNT_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.\n";


    private OutputView() { }

    public static void printLottos(LottoBundle lottoBundle) {
        List<Lotto> value = lottoBundle.value();
        System.out.printf(AMOUNT_MESSAGE, value.size());
        for (Lotto lotto : value) {
            System.out.println(StringUtil.formatLottoNumbers(lotto));
        }
    }

    public static void printResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        StringUtil.makeResultMessage(sb, lottoResult);
        System.out.println(sb);
    }

    public static void printProfit(Profit profit) {
        System.out.printf(TOTAL_PROFIT, profit.value());
    }
}
