public class WordFrequencyGame {

    public String getResult(String inputStr) {
        return Words
                .createFromString(inputStr)
                .getWordFrequency()
                .toString();
    }
}
