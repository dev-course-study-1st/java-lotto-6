package utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import utils.enums.ConstantNumber;

import java.util.List;

public class LottoNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(ConstantNumber.LOTTO_NUMBER_MIN.getNumber(), ConstantNumber.LOTTO_NUMBER_MAX.getNumber(), ConstantNumber.LOTTO_SIZE.getNumber());
    }

}
