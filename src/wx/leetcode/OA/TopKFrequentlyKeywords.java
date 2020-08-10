package wx.leetcode.OA;
import java.util.*;

public class TopKFrequentlyKeywords {
    /**
     * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
     *
     * The comparison of strings is case-insensitive.
     * Multiple occurances of a keyword in a review should be considred as a single mention.
     * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
     *
     * Example 1:
     *
     * Input:
     * k = 2
     * keywords = ["anacell", "cetracular", "betacellular"]
     * reviews = [
     *   "Anacell provides the best services in the city",
     *   "betacellular has awesome services",
     *   "Best services provided by anacell, everyone should use anacell",
     * ]
     *
     * Output:
     * ["anacell", "betacellular"]
     *
     * Explanation:
     * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
     */


    public static List<String> topK(String[] keywords, String[] reviews, int K) {
        List<String> res = new ArrayList<>();
        //high level: Split reviews, count the keyword occurrence in review, sort the result or PQ
        //time: review.length = N, keywords.length =  K    O(N + klogk)
        Map<String, Integer> count = new HashMap<>();
        for (String word : keywords) {
            count.put(word, 0);
        }
        for (String review : reviews) {
            String[] words = review.split("\\W");
            Set<String> seen = new HashSet<>();
            for (String word : words) {
                word = word.toLowerCase();
                if (count.containsKey(word) && !seen.contains(word)) {
                    count.put(word, count.get(word) + 1);
                    seen.add(word);
                }
            }
        }
        Arrays.sort(keywords, (a, b) -> {
            if (count.get(a) == count.get(b)) {
                return a.compareTo(b);
            }
            return count.get(b) - count.get(a);
        });

        for (int i = 0; i < K; i++) {
            if (count.get(keywords[i]) == 0) break;
            res.add(keywords[i]);
        }
        return res;
    }
}
