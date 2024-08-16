package lotto.model;

import lotto.utils.constant.LottoGameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BudgetTest {

    @DisplayName("로또 한장의 가격보다 작은 금액으로 예산을 생성하면 예외가 발생한다.")
    @Test
    void createBudgetByUnderOfLottoPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Budget(LottoGameNumber.LOTTO_GAME_PRICE.getNumber() - 1));
    }

    @DisplayName("로또 한장의 가격으로 나누어 떨어지지 않는 금액으로 예산을 생성하면 예외가 발생한다.")
    @Test
    void createBudgetByNotDivisibleOfLottoPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Budget(LottoGameNumber.LOTTO_GAME_PRICE.getNumber() + 1));
    }

}
