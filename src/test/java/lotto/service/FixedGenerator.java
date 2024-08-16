package lotto.service;

import lotto.model.Lotto;
import lotto.utils.generate.LottoGenerator;

import java.util.List;

public class FixedGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return new Lotto(List.of(1,2,3,4,5,6));
    }
}
