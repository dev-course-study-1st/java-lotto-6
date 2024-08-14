package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체가 정상적으로 생성된다. value 값이 정확히 저장된다.")
    void createMoneySuccess() {
        // Given
        int value = 5000;

        // When
        Money money = new Money(value);

        // Then
        assertEquals(value, money.value(), "Money 객체의 value 값이 입력한 값과 일치해야 합니다.");
    }

    @Test
    @DisplayName("getAmount 메서드가 정확한 금액을 반환한다.")
    void getAmountReturnsCorrectValue() {
        // Given
        int value = 5000;
        Money money = new Money(value);

        // When
        int amount = money.getAmount();

        // Then
        assertEquals(5, amount, "5000원의 경우 5가 반환되어야 합니다.");
    }

    @Test
    @DisplayName("0원이 주어졌을 때 getAmount 메서드가 0을 반환한다.")
    void getAmountReturnsZeroForZeroValue() {
        // Given
        Money money = new Money(0);

        // When
        int amount = money.getAmount();

        // Then
        assertEquals(0, amount, "0원의 경우 0이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("1000원 미만의 값이 주어졌을 때 getAmount 메서드가 0을 반환한다.")
    void getAmountReturnsZeroForValueBelow1000() {
        // Given
        Money money = new Money(999);

        // When
        int amount = money.getAmount();

        // Then
        assertEquals(0, amount, "999원의 경우 0이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("1000원이 정확히 주어졌을 때 getAmount 메서드가 1을 반환한다.")
    void getAmountReturnsOneForExactly1000() {
        // Given
        Money money = new Money(1000);

        // When
        int amount = money.getAmount();

        // Then
        assertEquals(1, amount, "1000원의 경우 1이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("음수 value가 주어졌을 때 getAmount 메서드가 올바르게 처리되는지 확인한다.")
    void getAmountHandlesNegativeValues() {
        // Given
        Money money = new Money(-1000);

        // When
        int amount = money.getAmount();

        // Then
        assertEquals(-1, amount, "음수 1000원의 경우 -1이 반환되어야 합니다.");
    }
}
