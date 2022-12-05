package handlers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    WordCounter wordCounter;

    @ParameterizedTest
    @NullSource
    void check_null_payload(Stream<String> payload) {
        assertThrows(NullPointerException.class, () -> {
            wordCounter = new WordCounterImpl('d', payload);
            wordCounter.getWords();
        });
    }

    @Test
    void check_no_payload() {
        wordCounter = new WordCounterImpl('d', Stream.<String>builder().build());
        Map<String, Integer> emptyMap = new HashMap<>();
        assertEquals(emptyMap, wordCounter.getWordsMap());
    }

    @Test
    void check_valid_payload() {
        String testString = "Возле стола стоял стул. Стул стоял возле стола";
        Stream<String> testStream = Stream.<String>builder().add(testString).build();
        wordCounter = new WordCounterImpl('d', testStream);
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("стола", 2);
        testMap.put("стул.", 1);
        testMap.put("стоял", 2);
        testMap.put("Стул", 1);
        testMap.put("возле", 1);
        testMap.put("Возле", 1);
        assertEquals(testMap, wordCounter.getWordsMap());
    }
}
