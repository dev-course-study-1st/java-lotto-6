package lotto.model;

import lotto.utils.constant.ErrorMessage;
import lotto.utils.constant.LottoGameNumber;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void validateBudgetDivisionPrice(int budget) {
        if(budget % LottoGameNumber.LOTTO_GAME_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private void validateBudgetMinPrice(int budget) {
        if(budget < LottoGameNumber.LOTTO_GAME_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MIN_MONEY.getMessage());
        }
    }

    private void validateBudget(int budget) {
        validateBudgetDivisionPrice(budget);
        validateBudgetMinPrice(budget);
    }
}
