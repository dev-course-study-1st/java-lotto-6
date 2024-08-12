package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.util.converter.ConverterHolder;
import lotto.util.converter.StringToMoneyConverter;

public class AppConfig {

    public LottoController setSystem() {

        addConverters();
        return new LottoController();
    }

    private void addConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToMoneyConverter()
        ));
    }

    public void terminateSystem() {
        ConverterHolder.clearHolder();
    }
}
