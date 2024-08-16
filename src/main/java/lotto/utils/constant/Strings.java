package lotto.utils.constant;

public enum Strings {


    ONLY_NUMBER_REGEX("^[0-9]+$");

    private final String string;

    Strings (String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
