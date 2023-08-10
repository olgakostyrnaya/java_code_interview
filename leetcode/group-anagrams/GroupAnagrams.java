//hashmap где переопределили compare?

// у нас есть массив стрингов
// нужно вернуть массив массивов
// если сумма по ascii = то add

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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