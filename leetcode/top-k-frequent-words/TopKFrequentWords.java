
class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
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
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}