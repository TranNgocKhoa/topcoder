package top_k_freq_words;

import java.util.*;

public class Solution {
    public static List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        Trie[] buckets = new Trie[words.length + 1];
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new Trie();
            }

            String word = entry.getKey();
            buckets[frequency].addWord(word);
        }

        List<String> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                List<String> retrieveWords = new ArrayList<>();
                buckets[i].getWords(buckets[i].root, retrieveWords);
                if (retrieveWords.size() < k - topK.size()) {
                    topK.addAll(retrieveWords);
                } else {
                    topK.addAll(retrieveWords.subList(0, k - topK.size()));
                }
            }
        }

        return topK;
    }

    public static void generateFrequencyMap(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n\tFrequency map: ");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printWords(String[] words) {
        StringBuilder sb = new StringBuilder();
        System.out.print("[");

        for (int j = 0; j < words.length; j++) {
            System.out.print(words[j]);
            if (j < words.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String[][] words = {
                {"apple", "banana", "orange", "banana", "banana"},
                {"cat", "dog", "fish", "bird", "cat", "dog", "fish", "bird"},
                {"python", "python", "python", "python", "python", "python", "python", "python", "python", "python"},
                {"a", "b", "c", "a", "b", "a"},
                {"tree", "bush", "flower", "tree", "bush", "tree", "rock", "rock", "grass"}
        };

        int[] k = {2, 4, 1, 3, 4};

        for (int i = 0; i < words.length; i++) {
            System.out.print((i + 1) + ".\tInput list: ");
            printWords(words[i]);
            generateFrequencyMap(words[i]);
            List<String> result = topKFrequentWords(words[i], k[i]);
            System.out.println("\n\tTop " + k[i] + " frequent word(s): " + result);
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }


    }
}

class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            } else {
                continue;
            }
        }
        cur.word = word;
    }

    public void getWords(TrieNode node, List<String> ans) {
        if (node == null) {
            return;
        }
        if (node.word != null) {
            ans.add(node.word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                getWords(node.children[i], ans);
            }
        }
    }
}
