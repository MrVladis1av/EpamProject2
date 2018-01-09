package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private List<Word> words;
    private Map<Integer, PunctuationMark> punctuationMark;
    private int size;


    {
        words = new ArrayList<Word>();
        punctuationMark = new HashMap<Integer, PunctuationMark>();
    }

    public Sentence() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sentence(String sentence) {
        init(sentence);
    }

    private void init(String s) {
        size = s.length();
        String[] tempWords = s.split(" ");
        int count = 0;
        Pattern p = Pattern.compile("^([A-Za-z]|[А-Яа-я])+[.,!?:;\'\"]$");
        Matcher m;
        for (String word : tempWords) {
            m = p.matcher(word);
            if (m.find()) {
                punctuationMark.put(count, new PunctuationMark(word.charAt(word.length() - 1)));
                word = word.substring(0, word.length() - 1);
            }
            Word temp = new Word(word);
            words.add(temp);
            count++;
        }

    }

    public void printSentence() {
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i));
            if (punctuationMark.containsKey(i)) {
                System.out.print(punctuationMark.get(i));
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public int getNumOfWords() {
        return words.size();
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Map<Integer, PunctuationMark> getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(Map<Integer, PunctuationMark> punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                ", punctuationMark=" + punctuationMark +
                '}';
    }
}
