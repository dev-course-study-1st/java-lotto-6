package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.service.LottoMachine;
import lotto.service.LottoService;
import lotto.util.converter.ConverterHolder;
import lotto.util.converter.StringToLottoConverter;
import lotto.util.converter.StringToMoneyConverter;
import lotto.util.generator.NumberGenerator;
import lotto.util.generator.OnServiceNumberGenerator;

public class AppConfig {

    public LottoController setSystem() {

        addConverters();
        return new LottoController(lottoService());
    }

    private LottoService lottoService() {
        return new LottoService(lottoMachine());
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(numberGenerator());
    }

    private NumberGenerator numberGenerator() {
        return new OnServiceNumberGenerator();
    }

    private void addConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToMoneyConverter(),
                new StringToLottoConverter()
        ));
    }

    public void terminateSystem() {
        ConverterHolder.clearHolder();
    }
}
