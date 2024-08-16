package lotto.util;

import java.util.List;
import lotto.util.generator.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
