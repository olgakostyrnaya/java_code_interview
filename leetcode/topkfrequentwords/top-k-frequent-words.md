# top-k-frequent-words.md

+ [top-k-frequent-words](#top-k-frequent-words)

## top-k-frequent-words

https://leetcode.com/problems/top-k-frequent-words/
## Размышления
    
    

## Сomplexity
    Time Complexity: O(N log N), but why?
    Memory Complexity: O(N), т.к. зависим только от входных данных 

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopKFrequentWordsTest {

    private TopKFrequentWords topKFrequentWords;

    @BeforeEach
    void setUp() {
        topKFrequentWords = new TopKFrequentWords();
    }

    @Test
    void returnInLexicographicalOrderIfCountsTheSame() {
        String [] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> expected = new ArrayList<>();
        expected.add("i");
        expected.add("love");
        assertEquals(expected, topKFrequentWords.topKFrequent(words, k));
    }

    @Test
    void returnInOrderOfWordsCount() {
        String [] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        List<String> expected = new ArrayList<>();
        expected.add("the");
        expected.add("is");
        expected.add("sunny");
        expected.add("day");

        assertEquals(expected, topKFrequentWords.topKFrequent(words, k));
    }
}
```

</blockquote></details>

``` java
import java.util.*;
import java.util.stream.Collectors;

class TopKFrequentWords {

    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.count == b.count) {
                    return a.word.compareTo(b.word);
                } else {
                    return b.count - a.count;
                }
            }
        };
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(comparator);

        Map<String, Integer> map = new HashMap<>();

        Integer count = 0;
        for (String word : words) {
            if (map.containsKey(word)) {
                count = map.get(word);
            } else {
                count = 0;
            }
            map.put(word, ++count);
        }

        for (Map.Entry element : map.entrySet()) {
            queue.add(new Pair((String) element.getKey(), (int) element.getValue()));
        }

        List<String> result = new ArrayList<String>();
        while (!queue.isEmpty() && k > 0) {
            result.add(queue.poll().word);
            k--;
        }

        return result;
    }

    public List<String> topKFrequentStraightforward(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        Integer count;
        for (String word : words) {
            if (map.containsKey(word)) {
                count = map.get(word);
            } else {
                count = 0;
            }
            map.put(word, ++count);
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
} 
```