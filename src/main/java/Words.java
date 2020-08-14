import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;

public class Words extends ArrayList<Word> {

    private static final String WORD_SPLITTER = "\\s+";

    static Words createFromString(String inputStr) {
        Words words = new Words();
        Arrays.stream(inputStr.split(WORD_SPLITTER))
                .forEach(wordString -> words.add(new Word(wordString)));
        return words;
    }

    public WordFrequency getWordFrequency() {
        WordFrequency wordFrequency = new WordFrequency();
        stream()
                .collect(groupingBy(word -> word))
                .forEach((key, value) -> wordFrequency.add(new WordCount(key, value.size())));
        return wordFrequency;
    }
}
