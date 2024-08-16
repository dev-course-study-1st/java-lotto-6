package lotto.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("빈 로또가 있으면 로또 목록이 생성되지 않는다.")
    @Test
    void createLottosByEmptyLotto() {
        List<Integer> numbers1 = List.of(1,2,3,4,5,6);
        List<Integer> numbers2 = List.of();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottos(List.of(new Lotto(numbers1), new Lotto(numbers2))));
    }

    @DisplayName("로또 목록이 정상적으로 입력 되면 로또 목록이 생성된다.")
    @Test
    void createLottos() {
        List<Integer> numbers1 = List.of(1,2,3,4,5,6);
        List<Integer> numbers2 = List.of(7,8,9,10,11,12);
        assertThatCode(() -> new Lottos(List.of(new Lotto(numbers1), new Lotto(numbers2))))
                .doesNotThrowAnyException();
    }
}
