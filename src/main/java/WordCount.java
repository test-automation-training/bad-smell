import java.util.Objects;

public class WordCount {
    private static final String VIEW_TEMPLATE = "%s %d";
    private final Word word;
    private final int count;

    public WordCount(Word word, int count) {
        this.word = word;
        this.count = count;
    }

    public Word getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format(VIEW_TEMPLATE, word, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return word.equals(wordCount.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
