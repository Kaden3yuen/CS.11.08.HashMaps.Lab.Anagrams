import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> Maps = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = reader.readLine()) != null) {
                String sortedWord = sortString(word);
                Maps.putIfAbsent(sortedWord, new ArrayList<>());
                Maps.get(sortedWord).add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maps;
    }



    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        int Max  = 0;
        ArrayList<String> frequentList = new ArrayList<>();

        for (ArrayList<String> anagramList : anagrams.values()) {
            if (anagramList.size() > Max) {
                Max = anagramList.size();
                frequentList = anagramList;
            }
        }
        return frequentList;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (String key : anagrams.keySet()) {
            System.out.println(key + ": " + anagrams.get(key));
        }
    }
    private static String sortString(String input) {
        char[] charArray = input.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }
}
