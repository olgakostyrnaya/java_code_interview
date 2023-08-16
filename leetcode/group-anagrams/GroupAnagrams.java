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