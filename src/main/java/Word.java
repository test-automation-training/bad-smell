import java.util.Objects;

public class Word {
    private final String text;

    public Word(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return text.equals(word.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
