package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoList.size())
                    .append("개를 구매했습니다.\n");

        for (Lotto lotto : lottoList) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
