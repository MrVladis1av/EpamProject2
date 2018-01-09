package model;

import java.util.Objects;

public class PunctuationMark {
    private char punctuationMark;

    public PunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return punctuationMark == that.punctuationMark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(punctuationMark);
    }

    public PunctuationMark() {
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        return "" + punctuationMark;
    }
}
