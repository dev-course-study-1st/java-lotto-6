package model;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final int winningPrice;

    LottoRank(int matchingCount, int winningAmount) {
        this.matchingCount = matchingCount;
        this.winningPrice = winningAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
