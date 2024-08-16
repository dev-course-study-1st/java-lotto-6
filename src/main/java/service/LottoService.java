package service;

import model.*;
import utils.enums.ConstantNumber;
import utils.generator.LottoNumbersGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoService {
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoService(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public Lottos generateLottos(int price) {
        int numberOfLottos = price / ConstantNumber.LOTTO_PRICE_UNIT.getNumber();
        return new Lottos(generateLottoList(numberOfLottos));
    }

    private List<Lotto> generateLottoList(int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(lottoNumbersGenerator.generate()))
                .toList();
    }

    public LottoResult calculateLottoResult(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoRanks = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoRanks.put(rank, 0);
        }
        for (Lotto lotto : lottos.getLottoList()) {
            LottoRank rank = calculateRank(lotto, winningLotto);
            lottoRanks.put(rank, lottoRanks.get(rank) + 1);
        }
        return new LottoResult(lottoRanks);
    }

    public double calculateYield(LottoResult lottoResult, int price) {
        int totalWinningPrice = lottoResult.getTotalWinningPrice();
        return ((double) totalWinningPrice / price) * 100;
    }

    private LottoRank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(lotto, winningLotto.getWinningNumbers());
        boolean bonusMatch = lotto.contains(winningLotto.getBonusNumber());

        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.MISS;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto other) {
        return (int) lotto.getNumbers().stream()
                .filter(other::contains)
                .count();
    }


}
