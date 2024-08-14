package lotto.model;

import java.util.List;

public class Player {
    private final Lottos lottos;
    private final Budget budget;

    public Player(Lottos lottos, Budget budget) {
        this.lottos = lottos;
        this.budget = budget;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Budget getBudget() {
        return budget;
    }

    public int getLottoCount() {
        return lottos.getLottos().size();
    }

    public List<Lotto> getLottosList() {
        return lottos.getLottos();
    }
}
