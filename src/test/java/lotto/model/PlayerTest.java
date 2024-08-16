package lotto.model;

import lotto.utils.constant.LottoGameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("로또 가격보다 적은 돈으로 로또를 구매하면 예외가 발생한다.")
    @Test
    void createPlayerByUnderOfLottoPrice() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(lottos, new Budget(LottoGameNumber.LOTTO_GAME_PRICE.getNumber()-1)));
    }

    @DisplayName("로또 가격으로 나누어 떨어지지 않는 금액으로 로또를 구매하면 예외가 발생한다.")
    @Test
    void createPlayerByNotDivisibleOfLottoPrice() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(lottos, new Budget(LottoGameNumber.LOTTO_GAME_PRICE.getNumber()+1)));
    }


}
