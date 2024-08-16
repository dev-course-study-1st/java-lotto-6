package lotto.model;

import lotto.utils.constant.LottoGameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 게임 범위의 최솟값보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(LottoGameNumber.LOTTO_RANDOM_MIN_NUMBER.getNumber() - 1));
    }

    @DisplayName("보너스 번호가 게임 범위의 최댓값보다 크면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(LottoGameNumber.LOTTO_RANDOM_MAX_NUMBER.getNumber() + 1));
    }

    @DisplayName("보너스 번호가 게임 범위 내에 있으면 생성된다")
    @Test
    void createBonusNumberByInRange() {
        assertThatCode(() -> new BonusNumber(10))
                .doesNotThrowAnyException();
    }

}
