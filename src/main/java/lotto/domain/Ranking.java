package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    DEFAULT(0, false, 0);

    private final int count;
    private final boolean isBonus;
    private final int price;

    Ranking(int count, boolean isBonus, int price) {
        this.count = count;
        this.isBonus = isBonus;
        this.price = price;
    }

    public static Ranking findRanking(int cnt, boolean isBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == cnt && ranking.isBonus == isBonus)
                .findAny()
                .orElse(DEFAULT);
    }

    public int getPrice() {
        return price;
    }
}
