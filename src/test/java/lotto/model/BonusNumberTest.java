package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.constant.Errors.ONLY_CONTAIN_NUMBERS_ERROR_MSG;
import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {


    @Test
    @DisplayName("보너스 볼번호 정상 생성")
    void makeBonusNumberTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        assertThat(winningNumber.getNumbers().contains(bonusNumber.getBonusNumber())).isEqualTo(false);
    }

    @Test
    @DisplayName("보너스 볼 번호에 문자 있으면 오류 발생")
    void bonusNumberLetterTest() {
        assertThatThrownBy(() -> new BonusNumber("15uu"))
                    .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONLY_CONTAIN_NUMBERS_ERROR_MSG.toString());
    }

    @Test
    @DisplayName("보너스 볼 번호가 1~45이내의 숫자가 아니면 오류 발생")
    void bonusNumberRangeTest() {
        assertThatThrownBy(() -> new BonusNumber("48"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONLY_CONTAIN_NUMBERS_ERROR_MSG.toString());
    }
}
