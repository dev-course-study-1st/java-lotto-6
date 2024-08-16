package lotto.utils.generate;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.utils.constant.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator implements LottoGenerator{
    @Override
    public Lotto generate() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(Numbers.MIN.getValue(), Numbers.MAX.getValue(), Numbers.LOTTO_SIZE.getValue());
        List<Integer> lottoNumber = new ArrayList<>(list);
        lottoNumber.sort(null);
        return new Lotto(lottoNumber);
    }

}