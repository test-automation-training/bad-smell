import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class WordFrequencyGame {

    private static final String WORD_SPLITTER = "\\s+";
    private static final String RESULT_DELIMITER = "\n";
    private static final String VIEW_TEMPLATE = "%s %d";

    public String play(String inputStr) {
        return generateResult(accumulate(split(inputStr)));
    }

    private String generateResult(Map<String, Integer> accumulateWords) {
        return accumulateWords.entrySet().stream()
                .sorted((right, left) -> left.getValue() - right.getValue())
                .map(wordFrequency -> String.format(VIEW_TEMPLATE, wordFrequency.getKey(), wordFrequency.getValue()))
                .collect(joining(RESULT_DELIMITER));
    }

    private Map<String, Integer> accumulate(List<String> splitWords) {
        return splitWords.stream()
                .collect(groupingBy(word -> word))
                .entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    private List<String> split(String inputStr) {
        return Arrays.asList(inputStr.split(WORD_SPLITTER));
    }

}
