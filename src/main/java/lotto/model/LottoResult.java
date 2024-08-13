package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = initializeLottoResult();
    }

    private Map<LottoRank, Integer> initializeLottoResult() {
        Map<LottoRank, Integer> initResult = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            initResult.put(lottoRank, 0);
        }
        return initResult;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return new HashMap<>(lottoResult);
    }

    public void updateLottoResult(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
    }

    public double calculateRateOfReturn(double purchaseMoney) {
        double income = lottoResult.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return income / purchaseMoney * 100;
    }
}
