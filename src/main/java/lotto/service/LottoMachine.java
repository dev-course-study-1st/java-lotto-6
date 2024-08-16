package lotto.service;

import java.util.List;
import lotto.util.generator.NumberGenerator;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> getLottoNumber() {
        return numberGenerator.generate();
    }
}
