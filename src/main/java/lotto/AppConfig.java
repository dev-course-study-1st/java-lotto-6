package lotto;

import lotto.controller.LottoController;

public class AppConfig {

    public LottoController setSystem() {
        return new LottoController();
    }

}
