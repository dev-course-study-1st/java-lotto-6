package utils;

import utils.generator.NumbersGenerator;

import java.util.List;

public class FixedNumbersGenerator implements NumbersGenerator {
    private final List<Integer> numbers;

    public FixedNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
