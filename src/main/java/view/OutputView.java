package view;

import model.Lotto;
import model.LottoRank;
import model.LottoResult;
import model.Lottos;
import utils.enums.IOMessage;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        System.out.println(lottoList.size() + IOMessage.OUTPUT_LOTTO_PURCHASE.toString());
        lottoList.stream()
                .map(lotto -> formatLottoNumbers(lotto.getNumbers()))
                .forEach(System.out::println);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    public static void printLottoResult(LottoResult lottoResult){
        System.out.println(IOMessage.OUTPUT_WINNING_STATISTICS);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                printRankResult(lottoResult, rank);
            }
        }

    }

    private static void printRankResult(LottoResult lottoResult, LottoRank rank) {
        int count = lottoResult.getRankCount(rank);
        if (rank == LottoRank.SECOND) {
            printBonusRankResult(rank, count);
            return;
        }
        printNormalRankResult(rank, count);
    }

    private static void printBonusRankResult(LottoRank rank, int count) {
        System.out.printf(IOMessage.LOTTO_RANK_BONUS_RESULT.toString(), rank.getMatchingCount(), formatCurrency(rank.getWinningPrice()), count);
        System.out.println();
    }

    private static void printNormalRankResult(LottoRank rank, int count) {
        System.out.printf(IOMessage.LOTTO_RANK_RESULT.toString(), rank.getMatchingCount(), formatCurrency(rank.getWinningPrice()), count);
        System.out.println();
    }

    private static String formatCurrency(int price) {
        return String.format("%,d", price);
    }

    public static void printYield(double yield) {
        System.out.printf(IOMessage.OUTPUT_YIELD.toString(), yield);
    }
}
