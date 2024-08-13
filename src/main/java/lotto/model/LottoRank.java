package lotto.model;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND.matchCount) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount) {
                return lottoRank;
            }
        }
        return NONE;
    }
}
