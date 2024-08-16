package model;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoRanks;

    public LottoResult(Map<LottoRank, Integer> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public Map<LottoRank, Integer> getLottoRanks() {
        return lottoRanks;
    }

    public int getRankCount(LottoRank lottoRank) {
        return lottoRanks.getOrDefault(lottoRank, 0);
    }

    public int getTotalWinningPrice() {
        return lottoRanks.entrySet().stream()
                .mapToInt(e -> e.getKey().getWinningPrice() * e.getValue())
                .sum();
    }


}
