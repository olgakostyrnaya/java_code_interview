# group-anagrams.md

+ [group-anagrams](#group-anagrams)

## group-anagrams

https://leetcode.com/problems/group-anagrams/

## Размышления
    Straightforward решение: вычислять сумму по каждому слову, складывая коды ASCII для каждого символа в слове.
    Если сумма одинаковая, считаем что слова являются анаграммами друг друга. Сохраняем в хэш-мапу, 
    где ключ это сумма кодов ASCII, а значение это список со словами-анаграммами. Минус решения: могут быть колизии, 
    т.к. одна и та же сумма может получится при сложении разных комбинаций ASCII символов.
    Решение: тоже юзаем хэш-мапу, но в качестве ключа используем отсортированные символы слова. Это позволит избежать колизий

## Сomplexity
    Time Complexity: O(N), потому что нам однозначно нужно пройтись по всем элементам списка 
    Memory Complexity: O(N), потому что хэш мапа также будет содержать все N элементов

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
import java.util.*;

class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tempMap = new HashMap<>();
        for (String word : strs) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String sortedWord = new String(temp);
            List<String> similar = new ArrayList<>();
            if (tempMap.containsKey(sortedWord)) {
                similar = tempMap.get(sortedWord);
                similar.add(word);
            } else {
                similar.add(word);
                tempMap.put(sortedWord, similar);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (String sortedWord : tempMap.keySet()) {
            result.add(tempMap.get(sortedWord));
        }

        return result;
    }


    public List<List<String>> groupAnagramsWrong(String[] strs) {
        Map<Integer, List<String>> tempMap = new HashMap<Integer, List<String>>();


        for (String word : strs) {
            int sum = getSum(word);
            List<String> tempList;
            if (tempMap.containsKey(sum)) {
                tempList = tempMap.get(sum);
                tempList.add(word);
            } else {
                tempList = new ArrayList<String>();
                tempList.add(word);
                tempMap.put(sum, tempList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Integer sum : tempMap.keySet()) {
            result.add(tempMap.get(sum));
        }

        return result;

    }

    private int getSum(String word) {
        int sum = 0;
        for (char ch : word.toCharArray()) {
            sum = sum + (int) ch;
        }

        return sum;
    }
}
```