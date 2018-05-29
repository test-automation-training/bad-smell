import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
class WordFrequencyGame {

    private static final String SPLIT_REGEX = "\\s+";
    private static final String RECEIPT_DELIMITER = "\n";

    String play(String input) {
        return buildReceipt(buildWords(buildTexts(input)));
    }

    private List<String> buildTexts(String input) {
        return Arrays.asList(input.split(SPLIT_REGEX));
    }

    private List<Word> buildWords(List<String> texts) {
        return texts.stream()
                .collect(groupingBy(text -> text))
                .entrySet().stream()
                .map(e -> new Word(e.getKey(), e.getValue().size()))
                .collect(Collectors.toList());
    }

    private String buildReceipt(List<Word> sizedWords) {
        return sizedWords.stream()
                .sorted((w1, w2) -> w2.getCount() - w1.getCount())
                .map(w -> w.getText() + " " + w.getCount())
                .collect(joining(RECEIPT_DELIMITER));
    }
}
