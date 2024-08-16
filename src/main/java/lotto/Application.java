package lotto;

import controller.LottoController;
import service.LottoService;
import utils.generator.LottoNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService(new LottoNumbersGenerator()));
        lottoController.run();
    }
}
