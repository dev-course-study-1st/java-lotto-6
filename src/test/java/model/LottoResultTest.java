package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {
    @DisplayName("등급 개수 테스트")
    @Test
    void testGetRankCount() {
        Map<LottoRank, Integer> ranks = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 2
        );
        LottoResult lottoResult = new LottoResult(ranks);

        assertEquals(1, lottoResult.getRankCount(LottoRank.FIRST));
        assertEquals(2, lottoResult.getRankCount(LottoRank.SECOND));
        assertEquals(0, lottoResult.getRankCount(LottoRank.THIRD));

    }

    @DisplayName("총 당첨 금액 테스트")
    @Test
    void testGetTotalWinningPrice() {
        Map<LottoRank, Integer> ranks = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 1
        );
        LottoResult lottoResult = new LottoResult(ranks);
        int expectedPrice = LottoRank.FIRST.getWinningPrice() + LottoRank.SECOND.getWinningPrice();
        assertEquals(expectedPrice, lottoResult.getTotalWinningPrice());
    }

}