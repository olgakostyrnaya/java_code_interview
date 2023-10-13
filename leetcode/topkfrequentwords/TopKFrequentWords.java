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