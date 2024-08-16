package service;

import model.*;
import utils.enums.ConstantNumber;
import utils.generator.NumbersGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoService {
    private final NumbersGenerator numbersGenerator;

    public LottoService(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos generateLottos(int price) {
        int numberOfLottos = price / ConstantNumber.LOTTO_PRICE_UNIT.getNumber();
        return new Lottos(generateLottoList(numberOfLottos));
    }

    private List<Lotto> generateLottoList(int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(numbersGenerator.generate()))
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
        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(r -> r.getMatchingCount() == matchCount)
                .findFirst()
                .orElse(LottoRank.MISS);
        if (rank == LottoRank.SECOND && !bonusMatch) {
            rank = LottoRank.THIRD;
        }
        return rank;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto other) {
        return (int) lotto.getNumbers().stream()
                .filter(other::contains)
                .count();
    }


}