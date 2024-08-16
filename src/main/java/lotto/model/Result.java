package lotto.model;

import lotto.utils.constant.Strings;
import lotto.utils.constant.WinningPrice;

import static lotto.utils.constant.Strings.*;

public class Result {

    private final MatchCount matchCount;
    private long totalPrize;

    private double returnRate;

    public Result(MatchCount matchCount) {
        this.matchCount = matchCount;
    }

    public void addPrize(int prize) {
        this.totalPrize += prize;
    }

    public MatchCount getMatchCount() {
        return matchCount;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(WINNING_STATISTICS_MSG.toString()).append(SLASH);
        appendMatchInfo(sb, MATCH_THREE_MSG, WinningPrice.THREE);
        appendMatchInfo(sb, MATCH_FOUR_MSG, WinningPrice.FOUR);
        appendMatchInfo(sb, MATCH_FIVE_MSG, WinningPrice.FIVE);
        appendMatchInfo(sb, MATCH_SIX_WITH_BONUS_MSG, WinningPrice.SIX_WITH_BONUS);
        appendMatchInfo(sb, MATCH_SIX_MSG, WinningPrice.SIX);

        return sb.toString();
    }

    private void appendMatchInfo(StringBuilder sb, Strings matchMessage, WinningPrice price) {
        MatchCount count = getMatchCount();
        sb.append(matchMessage)
                .append(count.getCount(price))
                .append(COUNT_MSG);
    }
}
