package handlers;

import utils.MapUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounterImpl implements WordCounter {
    private final Map<String, Integer> wordsMap;
    private final Stream<String> data;

    public WordCounterImpl(char sortingType, Stream<String> data) {
        this.data = data;
        wordsMap = MapUtils.getSortedMap(sortingType);
    }

    @Override
    public Map<String, Integer> getWordsMap() {
        wordsMap.putAll(
                data
                        .flatMap(line -> Arrays.stream(line.split(" ")))
                        .collect(Collectors.toMap(
                            Function.identity(),
                            value -> 1,
                            Integer::sum)
                        )
        );
        return wordsMap;
    }

    @Override
    public String getWords() {
        StringBuilder result = new StringBuilder();
        this.getWordsMap().forEach((k, v) -> result
                .append(k)
                .append(" ")
                .append(v)
                .append("\n"));
        return result.toString();
    }
}
