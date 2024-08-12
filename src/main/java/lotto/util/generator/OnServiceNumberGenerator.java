package lotto.util.generator;

import static lotto.util.Const.END_INCLUSIVE;
import static lotto.util.Const.LOTTO_SIZE;
import static lotto.util.Const.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class OnServiceNumberGenerator implements NumberGenerator{

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue(), LOTTO_SIZE.getValue());
    }

}
