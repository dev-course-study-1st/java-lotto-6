package lotto.utils.constant;

public enum WinningPrice {
    NONE(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX_WITH_BONUS(3000000),
    SIX(2000000000);

    private final int winningPrice;

    WinningPrice(int winningPrice) {
        this.winningPrice = winningPrice;
    }

    public int getPrice() {
        return winningPrice;
    }

    public static WinningPrice getWinningPrice(int count, boolean bonusMatched) {
        if(count == Numbers.THREE.getValue()) {
            return THREE;
        }
        if(count == Numbers.FOUR.getValue()) {
            return FOUR;
        }
        if(count == Numbers.FIVE.getValue()) {
            if(bonusMatched) {
                return SIX_WITH_BONUS;
            }
            return FIVE;
        }
        if(count == Numbers.SIX.getValue()) {
            return SIX;
        }
        return NONE ;
    }
}
