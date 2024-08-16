package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @DisplayName("유효한 보너스 번호 생성 테스트")
    @Test
    void validBonusNumber() {
        int validNumber = 15;
        BonusNumber bonusNumber = new BonusNumber(validNumber);
        assertEquals(validNumber, bonusNumber.getNumber());
    }

    @DisplayName("보너스 번호 45초과 테스트")
    @Test
    void overBonusNumber() {
        int bonusNumber = 50;
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber));
    }

    @DisplayName("보너스 번호 1미만 테스트")
    @Test
    void underBonusNumber() {
        int bonusNumber = -3;
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber));
    }

}