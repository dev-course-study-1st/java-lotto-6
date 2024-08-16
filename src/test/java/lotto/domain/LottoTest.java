package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("Lotto 객체가 정상적으로 생성된다. 6개의 숫자가 주어졌을 때 예외가 발생하지 않는다.")
    void createLottoSuccess() {
        // Given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertNotNull(lotto);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("6개의 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    void createLottoFailure() {
        // Given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
        assertEquals("6자리 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("Lotto 객체가 특정 숫자를 포함하는지 확인한다.")
    void containsNumber() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // When
        boolean contains = lotto.contains(3);

        // Then
        assertTrue(contains, "Lotto 객체는 숫자 3을 포함하고 있어야 합니다.");
    }

    @Test
    @DisplayName("Lotto 객체가 특정 보너스 번호를 포함하는지 확인한다.")
    void hasBonusNumber() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // When
        boolean hasBonus = lotto.hasBonus(6);

        // Then
        assertTrue(hasBonus, "Lotto 객체는 보너스 번호로 숫자 6을 포함하고 있어야 합니다.");
    }

    @Test
    @DisplayName("Lotto 객체가 포함되지 않은 보너스 번호를 확인한다.")
    void doesNotHaveBonusNumber() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // When
        boolean hasBonus = lotto.hasBonus(7);

        // Then
        assertFalse(hasBonus, "Lotto 객체는 보너스 번호로 숫자 7을 포함하고 있지 않아야 합니다.");
    }
}
