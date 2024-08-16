package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.utils.constant.Numbers;
import lotto.utils.generate.LottoGenerator;

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

        for (int i = unitPrice; i < price.getPrice(); i += unitPrice) {
            lottoList.add(generator.generate());
        }
        return new Lottos(lottoList);
    }
}
