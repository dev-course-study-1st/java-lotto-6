package lotto.model;

import lotto.utils.constant.LottoGameNumber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {

    @DisplayName("1개 빼고 모두 일치, 보너스 번호 불일치 시 3등")
    @Test
    void valueOf_Third() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("1개 빼고 모두 일치, 보너스 번호 일치 시 2등")
    @Test
    void valueOf_Second() {
        // given
        int matchCount = LottoGameNumber.LOTTO_NUMBER_SIZE.getNumber() - 1;
        boolean matchBonus = true;

        // when
        LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호 전부 일치 시 1등")
    @Test
    void valueOf_First() {
        // given
        int matchCount = LottoGameNumber.LOTTO_NUMBER_SIZE.getNumber();
        boolean matchBonus = false;

        // when
        LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("일치하는 번호가 없을 시 NONE")
    @Test
    void valueOf_None() {
        // given
        int matchCount = 0;
        boolean matchBonus = false;

        // when
        LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.NONE);
    }
}
