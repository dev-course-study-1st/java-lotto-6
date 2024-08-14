package lotto.view;

import lotto.model.*;
import lotto.utils.constant.GameMessage;

import java.text.NumberFormat;

public class OutputView {

    public static void printLottoCount(Player player) {
        System.out.printf(GameMessage.OUTPUT_PURCHASED_LOTTO_COUNT.getMessage(), player.getLottoCount());
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getSortedNumbersToString)
                .forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(GameMessage.OUTPUT_RESULT_STATISTICS.getMessage());

        NumberFormat numberFormat = NumberFormat.getInstance();

        lottoResult.getLottoResult().entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE)
                .sorted((o1, o2) -> o1.getKey().getPrize() - o2.getKey().getPrize())
                .map(entry -> {
                    LottoRank lottoRank = entry.getKey();
                    int count = entry.getValue();
                    String formattedPrize = numberFormat.format(lottoRank.getPrize());
                    if (lottoRank == LottoRank.SECOND) {
                        return String.format(GameMessage.OUTPUT_LOTTO_RESULT_BONUS.getMessage(), lottoRank.getMatchCount(), formattedPrize, count);
                    }
                    return String.format(GameMessage.OUTPUT_LOTTO_RESULT.getMessage(), lottoRank.getMatchCount(), formattedPrize, count);
                })
                .forEach(System.out::print);
    }

    public static void printLottoRateOfReturn(double rateOfReturn) {
        System.out.printf(GameMessage.OUTPUT_RATE_OF_RETURN.getMessage(), String.format("%.1f", rateOfReturn));
    }
}
