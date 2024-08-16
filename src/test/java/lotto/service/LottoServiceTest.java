package lotto.service;

import lotto.model.*;
import lotto.utils.constant.Numbers;
import lotto.utils.constant.WinningPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    @InjectMocks
    private LottoService service;  // 테스트할 클래스

    @Mock
    private Price price;  // 가격 객체도 모의 객체로 설정

    @BeforeEach
    void setUp() {
        service = new LottoService(new FixedGenerator());
        price = new Price("1000");
    }

    @Test
    @DisplayName("여러개의 로또를 정상 생성")
    void createLottosTest() {
        Price price = new Price("8000");
        Lottos lottos = service.buyLotto(price);

        assertThat(lottos.getLottoList().size())
                    .isEqualTo(price.getPrice() / Numbers.LOTTO_UNIT_PRICE.getValue());
    }

    @Test
    @DisplayName("로또번호 3개 당첨된 경우")
    void matchThreeTest() {
        Lottos lottos = service.buyLotto(price);
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumber("1,3,5,7,9,11"), new BonusNumber("12"));

        Result winningResult = service.getWinningResult(lottos, winningNumbers);

        assertThat(winningResult.getTotalPrize()).isEqualTo(WinningPrice.THREE.getPrice());
    }

    @Test
    @DisplayName("로또번호 4개 당첨된 경우")
    void matchFourTest() {
        Lottos lottos = service.buyLotto(price);
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumber("1,2,3,5,7,9,"), new BonusNumber("12"));

        Result winningResult = service.getWinningResult(lottos, winningNumbers);

        assertThat(winningResult.getTotalPrize()).isEqualTo(WinningPrice.FOUR.getPrice());
    }

    @Test
    @DisplayName("로또번호 5개 당첨된 경우")
    void matchFiveTest() {
        Lottos lottos = service.buyLotto(price);
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumber("1,2,3,5,7,6,"), new BonusNumber("12"));

        Result winningResult = service.getWinningResult(lottos, winningNumbers);

        assertThat(winningResult.getTotalPrize()).isEqualTo(WinningPrice.FIVE.getPrice());
    }

    @Test
    @DisplayName("보너스볼을 포함해서 로또번호 6개 당첨된 경우")
    void matchSixWithBonusTest() {
        Lottos lottos = service.buyLotto(price);
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumber("1,2,3,5,7,4"), new BonusNumber("6"));

        Result winningResult = service.getWinningResult(lottos, winningNumbers);

        assertThat(winningResult.getTotalPrize()).isEqualTo(WinningPrice.SIX_WITH_BONUS.getPrice());
    }

    @Test
    @DisplayName("보너스볼 미포함 로또번호 6개 당첨된 경우")
    void matchSixTest() {
        Lottos lottos = service.buyLotto(price);
        WinningNumbers winningNumbers = new WinningNumbers(new WinningNumber("1,2,3,5,6,4"), new BonusNumber("7"));

        Result winningResult = service.getWinningResult(lottos, winningNumbers);

        assertThat(winningResult.getTotalPrize()).isEqualTo(WinningPrice.SIX.getPrice());
    }
}
