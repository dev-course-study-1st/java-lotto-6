package lotto.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 돈은_숫자만_입력_가능합니다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 양의_정수만_가능힙니다() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 천원_단위만_가능합니다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자와_쉼표만_가능합니다1() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5/6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자와_쉼표만_가능합니다2() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자는_1과_45사이의_숫자만_가능합니다1() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자는_1과_45사이의_숫자만_가능합니다2() {
        assertSimpleTest(() -> {
            runException("5000", "0,2,3,4,5,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자는_6자리_숫자만_가능합니다() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,9,10");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자는_중복되면_안됩니다() {
        assertSimpleTest(() -> {
            runException("5000", "1,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_숫자는_당첨번호에_중복되면_안됩니다() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_숫자는_문자를_포함하면_안됩니다() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "ㅁ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_숫자는_1과_45사이의_숫자만_가능합니다1() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_숫자는_1과_45사이의_숫자만_가능합니다2() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
