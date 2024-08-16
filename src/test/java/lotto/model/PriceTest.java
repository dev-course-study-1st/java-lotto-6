package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.constant.Errors.*;
import static org.assertj.core.api.Assertions.*;

public class PriceTest {

    @Test
    @DisplayName("가격 정상 생성")
    void createPriceTest() {
        assertThat(new Price("5000")).isInstanceOf(Price.class);
    }

    @Test
    @DisplayName("가격이 0원이면 오류남")
    void priceZeroTest() {
        assertThatThrownBy(() -> new Price("0")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PRICE_IS_ZERO_ERROR_MSG.toString());
    }

    @Test
    @DisplayName("가격이 0원 이하면 숫자형식에 맞지 않아서 오류남")
    void negativePriceTest() {
        assertThatThrownBy(() -> new Price("-1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONLY_CONTAIN_NUMBERS_ERROR_MSG.toString());
    }


    @Test
    @DisplayName("가격이 1000원 단위가 아니면 오류남")
    void notValidPriceTest() {
        assertThatThrownBy(() -> new Price("1500")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANNOT_DIV_BY_UNIT_PRICE_ERROR_MSG.toString());
    }
}
