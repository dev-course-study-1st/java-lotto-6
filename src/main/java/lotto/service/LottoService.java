package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Money;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoBundle buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getAmount(); i++) {
            List<Integer> lottoNumber = lottoMachine.getLottoNumber();
            lottos.add(new Lotto(lottoNumber));
        }
        return new LottoBundle(lottos);
    }
}
