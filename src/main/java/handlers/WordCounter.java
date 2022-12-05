package handlers;

import java.util.Map;
import java.util.stream.Stream;

public interface WordCounter {
    Map<String, Integer> getWordsMap();

    String getWords();
}
