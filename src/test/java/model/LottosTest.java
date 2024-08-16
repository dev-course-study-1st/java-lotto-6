package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    @DisplayName("로또 목록 반환 테스트")
    @Test
    void testLottoList() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottoList = List.of(lotto1, lotto2);
        Lottos lottos = new Lottos(lottoList);
        assertEquals(lottoList, lottos.getLottoList());
    }

}