package service;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedNumbersGenerator;
import utils.enums.ConstantNumber;
import utils.generator.NumbersGenerator;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {
    private LottoService lottoService;
    private static final int PRICE = 3000;
    private final List<Integer> fixedNumbers = List.of(6, 5, 3, 1, 2, 4);

    @BeforeEach
    void setUp() {
        NumbersGenerator numbersGenerator = new FixedNumbersGenerator(fixedNumbers);
        lottoService = new LottoService(numbersGenerator);
    }

    @DisplayName("로또 생성 사이즈 테스트")
    @Test
    void testGenerateLottosSize() {
        Lottos lottos = lottoService.generateLottos(PRICE);
        List<Lotto> lottoList = lottos.getLottoList();
        assertEquals(PRICE / ConstantNumber.LOTTO_PRICE_UNIT.getNumber(), lottoList.size());
    }

    @DisplayName("로또 오름차순 생성 테스트")
    @Test
    void testGenerateLottosNumbers() {
        List<Integer> sortedFixedNumbers = fixedNumbers.stream()
                .sorted()
                .toList();
        Lottos lottos = lottoService.generateLottos(PRICE);
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            assertEquals(sortedFixedNumbers, lotto.getNumbers());
        }
    }

    @DisplayName("로또 결과 계산 테스트")
    @Test
    void testCalculateLottoResult() {
        // 1등
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // 2등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winningLotto);

        Map<LottoRank, Integer> expectedRanks = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 1,
                LottoRank.THIRD, 0,
                LottoRank.FOURTH, 0,
                LottoRank.FIFTH, 0,
                LottoRank.MISS, 0
        );
        assertEquals(expectedRanks, lottoResult.getLottoRanks());
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void testCalculateYield() {
        LottoResult lottoResult = new LottoResult(Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 0,
                LottoRank.THIRD, 0,
                LottoRank.FOURTH, 0,
                LottoRank.FIFTH, 1,
                LottoRank.MISS, 0
        ));
        int price = 2000;

        double yield = lottoService.calculateYield(lottoResult, price);
        double expectedYield = Math.round(((2_000_000_000 + 5_000) / (double) price) * 100 * 100.0) / 100.0;
        assertEquals(expectedYield, yield);
    }
}