package lotto.model;

import lotto.utils.constant.Errors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    @DisplayName("당첨번호 생성 정상 실행")
    void makeWinningNumber() {
        String numbers = "1,3,17,18,45,34";
        WinningNumber winningNumber = new WinningNumber(numbers);

        assertThat(numbers.split(",").length).isEqualTo(winningNumber.getNumbers().size());
    }

    @Test
    @DisplayName("당첨번호 6개를 만들지 않으면 오류남.")
    void winningNumberSizeTest() {
        String numbers = "1,3,17,18,34";
        assertThatThrownBy(() -> new WinningNumber(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Errors.NOT_EQUAL_LOTTO_SIZE_ERROR_MSG.toString());
    }

    @Test
    @DisplayName("당첨번호를 1~45 이내로 만들지 않으면 오류남.")
    void winningNumberRangeTest() {
        String numbers = "0,3,17,18,26,34";
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Errors.NOT_EQUAL_LOTTO_SIZE_ERROR_MSG.toString());
    }

    @Test
    @DisplayName("당첨번호를 중복된 숫자 6개로 만들면 오류남")
    void winningNumberDuplicateTest() {
        String numbers = "1,3,1,18,26,34";
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Errors.NOT_EQUAL_LOTTO_SIZE_ERROR_MSG.toString());
    }

    @Test
    @DisplayName("당첨번호에 문자들어가면 오류남")
    void winningNumberLetterContainsTest() {
        String numbers = "1,3g,1,18,26,34";
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Errors.NOT_EQUAL_LOTTO_SIZE_ERROR_MSG.toString());
    }
}
