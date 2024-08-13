package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.constant.LottoGameNumber;

import java.util.List;

public class NumberGenerator {
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoGameNumber.LOTTO_RANDOM_MIN_NUMBER.getNumber(),
                                                LottoGameNumber.LOTTO_RANDOM_MAX_NUMBER.getNumber(),
                                                LottoGameNumber.LOTTO_NUMBER_SIZE.getNumber());
    }
}
