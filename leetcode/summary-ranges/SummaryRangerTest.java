import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryRangerTest {

    private SummaryRanger summaryRanger;

    @BeforeEach
    void setUp() {
        summaryRanger = new SummaryRanger();
    }

    @Test
    void whenNullReturnNull() {
        int[] nums = null;
        List<String> expected = null;

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }

    @Test
    void whenEmptyReturnEmpty() {
        int[] nums = new int[0];
        List<String> expected = new ArrayList<String>();

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }

    @Test
    void whenInterruptedNumsReturnRanges() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        expected.add("2->5");
        expected.add("7");
        expected.add("9");
        int[] nums = {0, 2, 3, 4, 5, 7, 9};
        List<String> actual = summaryRanger.summaryRanges(nums);

        assertEquals(expected, actual);
    }

    @Test
    void whenNumsContainNegativeNumbers() {
        List<String> expected = new ArrayList<>();
        expected.add("-9->-7");
        expected.add("-5->-4");
        expected.add("0->2");
        expected.add("4->5");
        int[] nums = {-9, -8, -7, -5, -4, 0, 1, 2, 4, 5};
        List<String> actual = summaryRanger.summaryRanges(nums);

        assertEquals(expected, actual);
    }

    @Test
    void whenNegativeAndPositiveNumberReturnTwoIntervals() {
        List<String> expected = new ArrayList<>();
        expected.add("-2");
        expected.add("3");
        int[] nums = {-2, 3};

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }
}
