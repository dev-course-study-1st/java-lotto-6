package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.constant.Errors.DUPLICATED_NUMBER_ERROR_MSG;
import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    private final WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

    @Test
    @DisplayName("보너스 번호를 포함한 당첨번호 정상 생성")
    void createWinningNumbersTest() {
        BonusNumber bonusNumber = new BonusNumber("7");
        assertThat(new WinningNumbers(winningNumber, bonusNumber)).isInstanceOf(WinningNumbers.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 오류")
    void winningNumberDuplicateTest() {
        BonusNumber bonusNumber = new BonusNumber("6");
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER_ERROR_MSG.toString());
    }
}
