package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.utils.generate.LottoGenerator;
import lotto.utils.generate.RandomGenerator;

public class AppConfig {

    public static LottoController config() {
        return new Singleton().getInstance();
    }

    static class Singleton {

        private final LottoController controller;

        private Singleton() {
            this.controller = getController();
        }

        public LottoController getInstance() {
            return this.controller;
        }

        private LottoController getController() {
            return new LottoController(getService());
        }

        private LottoService getService() {
            return new LottoService(getGenerator());
        }

        private LottoGenerator getGenerator() {
            return new RandomGenerator();
        }
    }
}
