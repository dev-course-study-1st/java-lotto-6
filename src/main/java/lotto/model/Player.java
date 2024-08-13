package lotto.model;

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
}
