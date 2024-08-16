package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RankingTest {

    @Test
    @DisplayName("6개 번호가 일치하고 보너스 번호가 없을 때 1등(FIRST) 등급이 반환된다.")
    void findRankingFirst() {
        // Given
        int matchingCount = 6;
        boolean isBonus = false;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.FIRST, ranking, "6개 번호가 일치하고 보너스 번호가 없을 때는 1등이어야 합니다.");
    }

    @Test
    @DisplayName("5개 번호가 일치하고 보너스 번호가 있을 때 2등(SECOND) 등급이 반환된다.")
    void findRankingSecond() {
        // Given
        int matchingCount = 5;
        boolean isBonus = true;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.SECOND, ranking, "5개 번호가 일치하고 보너스 번호가 있을 때는 2등이어야 합니다.");
    }

    @Test
    @DisplayName("5개 번호가 일치하고 보너스 번호가 없을 때 3등(THIRD) 등급이 반환된다.")
    void findRankingThird() {
        // Given
        int matchingCount = 5;
        boolean isBonus = false;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.THIRD, ranking, "5개 번호가 일치하고 보너스 번호가 없을 때는 3등이어야 합니다.");
    }

    @Test
    @DisplayName("4개 번호가 일치할 때 4등(FOURTH) 등급이 반환된다.")
    void findRankingFourth() {
        // Given
        int matchingCount = 4;
        boolean isBonus = false;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.FOURTH, ranking, "4개 번호가 일치할 때는 4등이어야 합니다.");
    }

    @Test
    @DisplayName("3개 번호가 일치할 때 5등(FIFTH) 등급이 반환된다.")
    void findRankingFifth() {
        // Given
        int matchingCount = 3;
        boolean isBonus = false;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.FIFTH, ranking, "3개 번호가 일치할 때는 5등이어야 합니다.");
    }

    @Test
    @DisplayName("일치하는 번호가 없을 때 DEFAULT 등급이 반환된다.")
    void findRankingDefault() {
        // Given
        int matchingCount = 0;
        boolean isBonus = false;

        // When
        Ranking ranking = Ranking.findRanking(matchingCount, isBonus);

        // Then
        assertEquals(Ranking.DEFAULT, ranking, "일치하는 번호가 없을 때는 DEFAULT 등급이어야 합니다.");
    }

    @Test
    @DisplayName("1등(FIRST) 등급의 상금이 2,000,000,000원인지 확인한다.")
    void getPriceFirst() {
        // Given
        Ranking ranking = Ranking.FIRST;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(2_000_000_000, price, "1등의 상금은 2,000,000,000원이어야 합니다.");
    }

    @Test
    @DisplayName("2등(SECOND) 등급의 상금이 30,000,000원인지 확인한다.")
    void getPriceSecond() {
        // Given
        Ranking ranking = Ranking.SECOND;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(30_000_000, price, "2등의 상금은 30,000,000원이어야 합니다.");
    }

    @Test
    @DisplayName("3등(THIRD) 등급의 상금이 1,500,000원인지 확인한다.")
    void getPriceThird() {
        // Given
        Ranking ranking = Ranking.THIRD;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(1_500_000, price, "3등의 상금은 1,500,000원이어야 합니다.");
    }

    @Test
    @DisplayName("4등(FOURTH) 등급의 상금이 50,000원인지 확인한다.")
    void getPriceFourth() {
        // Given
        Ranking ranking = Ranking.FOURTH;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(50_000, price, "4등의 상금은 50,000원이어야 합니다.");
    }

    @Test
    @DisplayName("5등(FIFTH) 등급의 상금이 5,000원인지 확인한다.")
    void getPriceFifth() {
        // Given
        Ranking ranking = Ranking.FIFTH;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(5_000, price, "5등의 상금은 5,000원이어야 합니다.");
    }

    @Test
    @DisplayName("DEFAULT 등급의 상금이 0원인지 확인한다.")
    void getPriceDefault() {
        // Given
        Ranking ranking = Ranking.DEFAULT;

        // When
        int price = ranking.getPrice();

        // Then
        assertEquals(0, price, "DEFAULT 등급의 상금은 0원이어야 합니다.");
    }
}
