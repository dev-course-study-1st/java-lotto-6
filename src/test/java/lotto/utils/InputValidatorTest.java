package lotto.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("당첨 번호 입력 형식이 (1,2,3,4,5,6)과 같이 올바르다면 예외를 발생시키지 않는다")
    @Test
    void validateWinningNumberInput() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        InputValidator.validateWinningNumberInput(input);

        // then
        assertThatCode(() -> InputValidator.validateWinningNumberInput(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호의 시작이 숫자로 시작하지 않으면 예외를 발생시킨다.")
    @Test
    void shouldThrowExceptionWhenWinningNumberStartsWithNotNumber() {
        // given
        String input = "a,2,3,4,5,6";

        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateWinningNumberInput(input));
    }

    @DisplayName("당첨 번호의 끝이 숫자로 끝나지 않으면 예외를 발생시킨다.")
    @Test
    void shouldThrowExceptionWhenWinningNumberEndsWithNotNumber() {
        // given
        String input = "1,2,3,4,5,a";

        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateWinningNumberInput(input));
    }

    @DisplayName("당첨 번호 입력에는 숫자와 쉼표(,)만 입력해야 한다.")
    @Test
    void shouldThrowExceptionWhenWinningNumberContainsNotNumberAndComma() {
        // given
        String input = "1,1235a2,3afsd1,4,5,...";

        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateWinningNumberInput(input));
    }
}
