import java.util.LinkedHashSet;

import static java.util.stream.Collectors.joining;

public class WordFrequency extends LinkedHashSet<WordCount> {
    private static final String RESULT_DELIMITER = "\n";

    @Override
    public String toString() {
        return stream()
                .sorted((left, right) -> right.getCount() - left.getCount())
                .map(WordCount::toString)
                .collect(joining(RESULT_DELIMITER));
    }
}
