package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<Sentence> sentences;
    private int size;

    {
        sentences = new ArrayList<Sentence>();
    }

    public Text() {
    }

    public Text(String text) {
        init(text);
    }

    private void init(String text) {
        size = text.length();
        text = text.replaceAll("\\s+", " ");
        Pattern p = Pattern.compile("([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
        Matcher m = p.matcher(text);
        while (m.find()) {
            sentences.add(new Sentence(m.group()));
        }
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Text{" +
                "sentences=" + sentences +
                '}';
    }
}
