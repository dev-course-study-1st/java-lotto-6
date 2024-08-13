package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoBundle buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getAmount(); i++) {
            List<Integer> lottoNumber = lottoMachine.getLottoNumber();
            Collections.sort(lottoNumber);
            lottos.add(new Lotto(lottoNumber));
        }
        return new LottoBundle(lottos);
    }

    public LottoResult calculateLotto(WinningLotto winningLotto, LottoBundle lottoBundle) {
        Map<Ranking, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoBundle.value()) {
            boolean isBonus = false;
            int count = getCount(lotto, winningLotto.getLotto());
            if (count == 5) {
                isBonus = lotto.hasBonus(winningLotto.getBonusNumber());
            }
            Ranking ranking = Ranking.findRanking(count, isBonus);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(result);
    }

    private int getCount(Lotto lotto, Lotto winingLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winingLotto::contains)
                .count();
    }

    public Profit calculateProfit(LottoResult lottoResult, Money money) {
        Map<Ranking, Integer> rankings = lottoResult.value();
        long sum = 0;
        for (Ranking ranking : rankings.keySet()) {
            sum += (long) rankings.get(ranking) * ranking.getPrice();
        }
        return new Profit(100.0 * sum / money.value());
    }
}
