package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto 객체가 정상적으로 생성된다.")
    void createWinningLottoSuccess() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);

        // When
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // Then
        assertNotNull(winningLotto);
        assertEquals(lotto, winningLotto.getLotto(), "WinningLotto 객체의 Lotto가 입력한 Lotto와 동일해야 합니다.");
        assertEquals(7, winningLotto.getBonusNumber(), "WinningLotto 객체의 보너스 번호가 7이어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 숫자에 포함되어 있으면 예외가 발생한다.")
    void createWinningLottoFailureDueToBonusNumberInLotto() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(6);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, bonusNumber));
        assertEquals("보너스 번호가 당첨 숫자에 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("WinningLotto 객체에서 Lotto와 BonusNumber 값을 정확하게 반환한다.")
    void getLottoAndBonusNumber() {
        // Given
        List<Integer> numbers = Arrays.asList(8, 9, 10, 11, 12, 13);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);

        // When
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // Then
        assertEquals(lotto, winningLotto.getLotto(), "getLotto 메서드는 입력한 Lotto 객체를 반환해야 합니다.");
        assertEquals(7, winningLotto.getBonusNumber(), "getBonusNumber 메서드는 입력한 보너스 번호를 반환해야 합니다.");
    }
}
