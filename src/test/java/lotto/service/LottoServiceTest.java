package lotto.service;

import lotto.domain.*;
import lotto.util.FixedNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new LottoMachine(new FixedNumberGenerator()));
    }

    @Test
    @DisplayName("Money 객체의 값에 따라 LottoBundle이 생성된다.")
    void buyLotto() {
        // Given
        Money money = new Money(5000);

        // When
        LottoBundle lottoBundle = lottoService.buyLotto(money);

        // Then
        assertNotNull(lottoBundle);
        assertEquals(5, lottoBundle.value().size(), "5000원을 입력했으므로 5개의 Lotto가 생성되어야 합니다.");
        for (Lotto lotto : lottoBundle.value()) {
            assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers(), "모든 Lotto는 고정된 숫자 리스트 [1, 2, 3, 4, 5, 6]을 가져야 합니다.");
        }
    }

    @Test
    @DisplayName("LottoResult가 WinningLotto와 LottoBundle을 기반으로 올바르게 계산된다.")
    void calculateLotto() {
        // Given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new BonusNumber(7));

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)) // 5등
        );
        LottoBundle lottoBundle = new LottoBundle(lottos);

        // When
        LottoResult lottoResult = lottoService.calculateLotto(winningLotto, lottoBundle);

        // Then
        assertEquals(1, lottoResult.value().get(Ranking.FIRST).intValue(), "1등이 1개 있어야 합니다.");
        assertEquals(1, lottoResult.value().get(Ranking.SECOND).intValue(), "2등이 1개 있어야 합니다.");
        assertEquals(1, lottoResult.value().get(Ranking.THIRD).intValue(), "3등이 1개 있어야 합니다.");
        assertEquals(1, lottoResult.value().get(Ranking.FOURTH).intValue(), "4등이 1개 있어야 합니다.");
        assertEquals(1, lottoResult.value().get(Ranking.FIFTH).intValue(), "5등이 1개 있어야 합니다.");
    }

    @Test
    @DisplayName("LottoResult와 투자 금액을 기반으로 Profit이 올바르게 계산된다.")
    void calculateProfit() {
        // Given
        Map<Ranking, Integer> resultMap = Map.of(
                Ranking.FIRST, 1, // 1등 1개
                Ranking.FIFTH, 2  // 5등 2개
        );
        LottoResult lottoResult = new LottoResult(resultMap);
        Money money = new Money(5000);

        // When
        Profit profit = lottoService.calculateProfit(lottoResult, money);

        // Then
        long expectedProfit = (Ranking.FIRST.getPrice() + 2L * Ranking.FIFTH.getPrice());
        assertEquals(100.0 * expectedProfit / money.value(), profit.value(), 0.01, "계산된 수익률이 정확해야 합니다.");
    }
}
