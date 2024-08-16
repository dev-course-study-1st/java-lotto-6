package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {
    @DisplayName("FIRST 등급의 매칭 개수와 상금 테스트")
    @Test
    void testFirstRankProperties() {
        LottoRank first = LottoRank.FIRST;
        assertEquals(6, first.getMatchingCount());
        assertEquals(2_000_000_000, first.getWinningPrice());
    }

    @DisplayName("SECOND 등급의 매칭 개수와 상금 테스트")
    @Test
    void testSecondRankProperties() {
        LottoRank second = LottoRank.SECOND;
        assertEquals(5, second.getMatchingCount());
        assertEquals(30_000_000, second.getWinningPrice());
    }

    @DisplayName("THIRD 등급의 매칭 개수와 상금 테스트")
    @Test
    void testThirdRankProperties() {
        LottoRank third = LottoRank.THIRD;
        assertEquals(5, third.getMatchingCount());
        assertEquals(1_500_000, third.getWinningPrice());
    }

    @DisplayName("FOURTH 등급의 매칭 개수와 상금 테스트")
    @Test
    void testFourthRankProperties() {
        LottoRank fourth = LottoRank.FOURTH;
        assertEquals(4, fourth.getMatchingCount());
        assertEquals(50_000, fourth.getWinningPrice());
    }

    @DisplayName("FIFTH 등급의 매칭 개수와 상금 테스트")
    @Test
    void testFifthRankProperties() {
        LottoRank fifth = LottoRank.FIFTH;
        assertEquals(3, fifth.getMatchingCount());
        assertEquals(5_000, fifth.getWinningPrice());
    }

    @DisplayName("MISS 등급의 매칭 개수와 상금 테스트")
    @Test
    void testMissRankProperties() {
        LottoRank miss = LottoRank.MISS;
        assertEquals(0, miss.getMatchingCount());
        assertEquals(0, miss.getWinningPrice());
    }
}