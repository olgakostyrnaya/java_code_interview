import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams;

    @BeforeEach
    void setUp() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<String>(Collections.singleton("bat")));
        ArrayList<String> secondGroup = new ArrayList<>();
        secondGroup.add("nat");
        secondGroup.add("tan");
        expected.add(secondGroup);
        ArrayList<String> thirdGroup = new ArrayList<>();
        thirdGroup.add("ate");
        thirdGroup.add("eat");
        thirdGroup.add("tea");
        expected.add(thirdGroup);

        List<List<String>> result = groupAnagrams.groupAnagrams(strs);

        for (List<String> list : expected) {
            Collections.sort(list);
        }

        for (List<String> list : result) {
            Collections.sort(list);
        }

        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }
}
