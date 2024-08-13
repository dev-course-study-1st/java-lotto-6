package lotto.domain;

import java.util.Map;

public record LottoResult (
        Map<Ranking, Integer> value
) {
}
