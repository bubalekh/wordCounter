package utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapUtils {
    public static Map<String, Integer> getSortedMap(char sortingType) {
        Map<String, Integer> resultMap;
        switch (sortingType) {
            case 'a':
                resultMap = new TreeMap<>();
                break;
            case 'c':
                resultMap = new LinkedHashMap<>();
                break;
            default:
                resultMap = new HashMap<>();
        }
        return resultMap;
    }
}
