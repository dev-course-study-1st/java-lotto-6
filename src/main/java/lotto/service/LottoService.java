package lotto.service;

import lotto.model.*;
import lotto.utils.constant.Numbers;
import lotto.utils.constant.WinningPrice;
import lotto.utils.generate.LottoGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoGenerator generator;

    public LottoService(LottoGenerator raneomGenerator) {
        this.generator = raneomGenerator;
    }

    public Lottos buyLotto(Price price) {
        List<Lotto> lottoList = new ArrayList<>();
        int unitPrice = Numbers.LOTTO_UNIT_PRICE.getValue();    //단위 가격

        for (int i = unitPrice; i <= price.getPrice(); i += unitPrice) {
            lottoList.add(generator.generate());
        }
        return new Lottos(lottoList);
    }

    public Result getWinningResult(Lottos lottos, WinningNumbers winningNumbers) {
        Result result = new Result(new MatchCount());

        for (Lotto lotto : lottos.getLottoList()) {
            int matchCount = winningNumbers.getMatchCount(lotto);
            boolean bonusMatched = winningNumbers.isBonusNumberMatched(lotto);
            WinningPrice winningPrice = WinningPrice.getWinningPrice(matchCount, bonusMatched);
            result.getMatchCount().setCount(winningPrice);
            result.addPrize(winningPrice.getPrice());
        }
        return result;
    }

    public double getReturnRate(Price price, long totalPrize) {
        double result = (double) totalPrize / price.getPrice();
        return Math.round(result * 1000) / 10.0;
    }
}
