package lotto.util;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ranking;

public class StringUtil {

    private static final String LOTTO_NUMBERS_FORMAT = "[%s]";
    private static final String DELIMITER = ", ";
    private static final String FINAL_STATICS = "당첨 통계\n";
    private static final String SPLIT_LINE = "---\n";
    private static final String FIFTH_RANK_LINE = "3개 일치 (5,000원) - %s개\n";
    private static final String FOURTH_RANK_LINE = "4개 일치 (50,000원) - %s개\n";
    private static final String THIRD_RANK_LINE = "5개 일치 (1,500,000원) - %s개\n";
    private static final String SECOND_RANK_LINE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n";
    private static final String FIRST_RANK_LINE = "6개 일치 (2,000,000,000원) - %s개\n";

    private StringUtil() { }

    public static String formatLottoNumbers(Lotto lotto) {
        List<String> numbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .toList();
        return String.format(LOTTO_NUMBERS_FORMAT, String.join(DELIMITER, numbers));
    }

    public static void makeResultMessage(StringBuilder sb, LottoResult lottoResult) {
        Map<Ranking, Integer> result = lottoResult.value();

        sb.append(FINAL_STATICS);
        sb.append(SPLIT_LINE);
        sb.append(String.format(FIFTH_RANK_LINE, result.getOrDefault(Ranking.FIFTH, 0)));
        sb.append(String.format(FOURTH_RANK_LINE, result.getOrDefault(Ranking.FOURTH, 0)));
        sb.append(String.format(THIRD_RANK_LINE, result.getOrDefault(Ranking.THIRD, 0)));
        sb.append(String.format(SECOND_RANK_LINE, result.getOrDefault(Ranking.SECOND, 0)));
        sb.append(String.format(FIRST_RANK_LINE, result.getOrDefault(Ranking.FIRST, 0)));
    }
}
