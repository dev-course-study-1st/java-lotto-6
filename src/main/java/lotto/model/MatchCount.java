package lotto.model;

import lotto.utils.constant.Numbers;
import lotto.utils.constant.WinningPrice;

import java.util.HashMap;
import java.util.Map;

public class MatchCount {

    private final Map<WinningPrice, Integer> countMap = new HashMap<>();

    public MatchCount() {}

    public int getCount(WinningPrice winningPrice) {
        return countMap.getOrDefault(winningPrice, Numbers.ZERO.getValue());
    }

    public void setCount(WinningPrice winningPrice) {
        countMap.put(winningPrice, getCount(winningPrice)+1);
    }
}
