package lotto.domain;

public record Money(int value) {

    public int getAmount() {
        return value / 1000;
    }
}
