package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextController {
    Text text;

    public TextController(Text text) {
        this.text = text;
    }

    public void sortSentences() {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = sentences.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sentences.get(j).getSize() > sentences.get(j + 1).getSize()) {
                    Sentence t = sentences.get(j);
                    sentences.set(j, sentences.get(j + 1));
                    sentences.set(j + 1, t);
                }
            }
        }
        for (Sentence sentence : sentences) {
            sentence.printSentence();
        }
    }

    public void findUniqueWord() {
        Sentence firstSentence = text.getSentences().get(0);
        Word uniqueWord;
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < firstSentence.getNumOfWords(); i++) {
            Word currentWord = firstSentence.getWords().get(i);
            for (int j = 1; j < sentences.size(); j++) {
                List<Word> wordsInSentence = sentences.get(j).getWords();
                if (!wordsInSentence.contains(currentWord)) {
                    uniqueWord = currentWord;
                    if (j == sentences.size() - 1) {
                        System.out.println(uniqueWord);
                        return;
                    }
                } else break;
            }
        }
    }

    public void printWordsInQuestionSentences(int length) {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < sentences.size(); i++) {
            if (sentences.get(i).getPunctuationMark().containsValue(new PunctuationMark('?'))) {
                for (int j = 0; j < sentences.get(i).getWords().size(); j++) {
                    if (sentences.get(i).getWords().get(j).size() == length)
                        System.out.println(sentences.get(i).getWords().get(j));

                }
            }
        }
    }

    public void changePositonOfLastAndFirstWord() {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < sentences.size(); i++) {
            Word temp = sentences.get(i).getWords().get(0);
            sentences.get(i).getWords().set(0, sentences.get(i).getWords().get(sentences.get(i).getWords().size() - 1));
            sentences.get(i).getWords().set(sentences.get(i).getWords().size() - 1, temp);
            sentences.get(i).printSentence();
        }
    }

    public void printSortedWords() {
        ArrayList<Word> words = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < sentences.get(i).getWords().size(); j++) {
                words.add(sentences.get(i).getWords().get(j));
            }
        }
        Collections.sort(words, (a, b) -> a.compareTo(b));
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }

    public void sortByVowelPart() {
        List<Word> words = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < sentences.get(i).getWords().size(); j++) {
                words.add(sentences.get(i).getWords().get(j));
            }
        }
        Collections.sort(words, (a, b) -> a.getVowelsPart() > b.getVowelsPart() ? 1 : -1);
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " - " + words.get(i).getVowelsPart());
        }
    }

    public void sortByFirstVowel() {
        List<Word> words = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < sentences.get(i).getWords().size(); j++) {
                if (sentences.get(i).getWords().get(j).getWord().get(0).isVowel())
                    words.add(sentences.get(i).getWords().get(j));
            }
        }
        Collections.sort(words, (a, b) -> a.compareTo(b));
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }

    public int getSentencesWithRepeatedWords() {
        List<Word> words = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        int count = 0, curCount = 0;
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < sentences.get(i).getWords().size(); j++) {
                words.add(sentences.get(i).getWords().get(j));
            }
        }
        for (int i = 0; i < words.size(); i++) {
            count = 0;
            for (int j = 0; j < sentences.size(); j++) {
                if (sentences.get(j).getWords().contains(words.get(i))) count++;
            }
            if (count > curCount) curCount = count;

        }
        return curCount;
    }
}
