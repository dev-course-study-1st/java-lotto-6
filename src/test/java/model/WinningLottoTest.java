package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {
    @DisplayName("당첨 번호와 보너스 번호 저장 테스트")
    @Test
    void testWinningLotto() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertEquals(winningNumbers, winningLotto.getWinningNumbers());
        assertEquals(bonusNumber.getNumber(), winningLotto.getBonusNumber());
    }

}