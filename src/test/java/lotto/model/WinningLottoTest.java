package lotto.model;

import lotto.utils.constant.LottoGameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외를 발생한다")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6)));
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 생성된다")
    @Test
    void createWinningLotto() {
        assertThatCode(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 6개 보다 작으면 예외를 발생한다")
    @Test
    void createWinningLottoByUnderSixSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5)), new BonusNumber(6)));
    }

    @DisplayName("당첨 번호가 6개 보다 크면 예외를 발생한다")
    @Test
    void createWinningLottoByOverSixSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)), new BonusNumber(8)));
    }

    @DisplayName("보너스 번호가 게임 범위의 최솟값보다 작으면 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(LottoGameNumber.LOTTO_RANDOM_MIN_NUMBER.getNumber() - 1)));
    }

    @DisplayName("보너스 번호가 게임 범위의 최댓값보다 크면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(LottoGameNumber.LOTTO_RANDOM_MAX_NUMBER.getNumber() + 1)));
    }

}
