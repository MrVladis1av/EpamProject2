package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word implements Comparable {
    private List<Symbol> word;

    {
        word = new ArrayList<Symbol>();
    }

    public Word(List<Symbol> word) {
        this.word = word;
    }

    public Word() {
    }

    public Word(String s) {
        for (int i = 0; i < s.length(); i++) {
            word.add(new Symbol(s.charAt(i)));
        }
    }

    public List<Symbol> getWord() {
        return word;
    }

    public int size() {
        return word.size();
    }

    public void setWord(List<Symbol> word) {
        this.word = word;
    }

    private String wordPresentation() {
        String result = "";
        for (int i = 0; i < word.size(); i++) {
            result += word.get(i);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        if (word1.word.size() != word.size()) return false;
        for (int i = 0; i < word.size(); i++) {
            if (!word1.word.get(i).equals(word.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return wordPresentation();
    }

    public double getVowelsPart() {
        int vowels = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).isVowel()) vowels++;
        }
        return (double)vowels / word.size();
    }

    @Override
    public int compareTo(Object o) {
        String s1 = "";
        String s2 = "";
        Word word1 = (Word) o;
        for (int i = 0; i < word.size(); i++) {
            s1 += word.get(i);
        }
        for (int i = 0; i < word1.size(); i++) {
            s2 += word1.word.get(i);
        }

        return s1.compareTo(s2);
    }
}
