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
