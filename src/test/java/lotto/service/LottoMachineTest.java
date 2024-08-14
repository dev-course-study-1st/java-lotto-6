package lotto.service;

import lotto.util.FixedNumberGenerator;
import lotto.util.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoMachineTest {

    @Test
    @DisplayName("FixedNumberGenerator를 사용하여 LottoMachine이 고정된 번호를 생성하는지 확인한다.")
    void getLottoNumberWithFixedGenerator() {
        // Given
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(fixedNumberGenerator);

        // When
        List<Integer> lottoNumbers = lottoMachine.getLottoNumber();

        // Then
        assertNotNull(lottoNumbers, "생성된 로또 번호 리스트는 null이 아니어야 합니다.");
        assertEquals(6, lottoNumbers.size(), "생성된 로또 번호 리스트의 크기는 6이어야 합니다.");
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lottoNumbers, "생성된 로또 번호 리스트는 [1, 2, 3, 4, 5, 6]이어야 합니다.");
    }
}
