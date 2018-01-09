package model;

import java.util.Objects;

public class Symbol implements Comparable {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
    }

    public boolean isVowel() {
        if (symbol == 'у'
                || symbol == 'е'
                || symbol == 'я'
                || symbol == 'а'
                || symbol == 'о'
                || symbol == 'э'
                || symbol == 'и'
                || symbol == 'ю'
                || symbol == 'У'
                || symbol == 'Е'
                || symbol == 'А'
                || symbol == 'О'
                || symbol == 'И'
                || symbol == 'Ю'
                || symbol == 'Я'
                )
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "" + symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {

        return Objects.hash(symbol);
    }

    @Override
    public int compareTo(Object o) {
        return symbol > (char) o ? 1 : -1;
    }
}
